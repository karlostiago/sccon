package com.sscon.service;

import com.sscon.entity.PersonEntity;
import com.sscon.enumeration.Age;
import com.sscon.enumeration.Salary;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.List;

@SpringBootTest
public class PeronsServiceTest {

    @Autowired
    private PersonService personService;

    @Test
    public void mustAddPersonWithSuccessWhenIdNotInformed() {
        final PersonEntity person = new PersonEntity(null, "Person Hardman", LocalDate.now(), LocalDate.now());

        personService.add(person);

        List<PersonEntity> entities = personService.findAll();
        Long idExpected = entities.get(entities.size() - 1).getId();

        Assertions.assertEquals(idExpected, personService.findById(idExpected).getId());
    }

    @Test
    public void mustAddPersonWithSuccessWhenIdInformed() {
        final Long idExpected = 5L;
        final PersonEntity person = new PersonEntity(idExpected, "Person Hardman", LocalDate.now(), LocalDate.now());

        personService.add(person);

        Assertions.assertEquals(idExpected, personService.findById(idExpected).getId());
    }

    @Test
    public void shouldReturnAnListPersons() {
        Assertions.assertEquals(3, personService.findAll().size());
    }

    @Test
    public void shouldFilterAnPersonById() {
        Assertions.assertEquals(1L, personService.findById(1L).getId());
    }

    @Test
    public void shouldDeleteAnPersonById() {
        Assertions.assertEquals(5, personService.findAll().size());

        personService.delete(2L);

        Assertions.assertEquals(4, personService.findAll().size());
    }

    @Test
    public void shouldReturnNumberDays() {
        final PersonEntity entity = personService.findById(1L);

        Assertions.assertEquals(8342, Age.DAYS.execute(entity.getDateBirth()));
    }

    @Test
    public void shouldReturnNumberMonths() {
        final PersonEntity entity = personService.findById(1L);

        Assertions.assertEquals(274, Age.MONTHS.execute(entity.getDateBirth()));
    }

    @Test
    public void shouldReturnNumberYears() {
        final PersonEntity entity = personService.findById(1L);

        Assertions.assertEquals(22, Age.YEARS.execute(entity.getDateBirth()));
    }

    @Test
    public void shouldReturnSalaryFull() {
        final PersonEntity entity = personService.findById(1L);

        Assertions.assertEquals(3259.36D, Salary.FULL.execute(entity.getDateEmisson()).doubleValue());
    }

    @Test
    public void shouldReturnSalaryMin() {
        final PersonEntity entity = personService.findById(1L);

        Assertions.assertEquals(2.51D, Salary.MIN.execute(entity.getDateEmisson()).doubleValue());
    }
}

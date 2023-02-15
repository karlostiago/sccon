package com.sscon.controller;

import com.sscon.assembler.PersonAssembler;
import com.sscon.entity.PersonEntity;
import com.sscon.entity.dto.PersonDTO;
import com.sscon.entity.input.PersonInput;
import com.sscon.enumeration.Age;
import com.sscon.enumeration.Salary;
import com.sscon.service.PersonService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
public class PersonController {

    private final PersonService personService;
    private final PersonAssembler assembler;

    public PersonController(PersonService personService, PersonAssembler assembler) {
        this.personService = personService;
        this.assembler = assembler;
    }

    @GetMapping(value = "/person")
    public List<PersonDTO> list() {
        return personService.findAll()
                .stream().map(assembler::toDTO)
                .toList();
    }

    @PostMapping(value = "/person")
    @ResponseStatus(HttpStatus.CREATED)
    public PersonDTO create(@RequestBody PersonInput personInput) {
        final PersonEntity entity = new PersonEntity(personInput.getId(), personInput.getName(), personInput.getDateBirth(), personInput.getDateEmisson());
        return assembler.toDTO(personService.add(entity));
    }

    @DeleteMapping(value = "/person/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        personService.delete(id);
    }

    @PutMapping(value = "/person/{id}")
    public PersonDTO update(@PathVariable Long id, @RequestBody PersonInput personInput) {
        return assembler.toDTO(personService.update(id, personInput));
    }

    @PatchMapping(value = "/person/{id}")
    public PersonDTO updateName(@PathVariable Long id, @RequestBody PersonInput personInput) {
        return assembler.toDTO(personService.updateName(id, personInput));
    }

    @GetMapping(value = "/person/{id}")
    public PersonDTO findById(@PathVariable Long id) {
        return assembler.toDTO(personService.findById(id));
    }

    @GetMapping(value = "/person/{id}/age")
    public Long age(@PathVariable Long id, @RequestParam Age output) {
        final PersonEntity personEntity = personService.findById(id);
        return output.execute(personEntity.getDateBirth());
    }

    @GetMapping(value = "/person/{id}/salary")
    public BigDecimal salary(@PathVariable Long id, @RequestParam Salary output) {
        final PersonEntity personEntity = personService.findById(id);
        return output.execute(personEntity.getDateEmisson());
    }
}

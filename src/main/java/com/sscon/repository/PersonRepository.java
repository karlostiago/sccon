package com.sscon.repository;

import com.sscon.entity.PersonEntity;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.*;

@Repository
public class PersonRepository {

    static final private Map<Long, PersonEntity> personsMap = new HashMap<>();
    private final List<PersonEntity> persons = new ArrayList<>();
    private static Long nextId = 0L;

    static {
        personsMap.put(1L, new PersonEntity(1L, "José Artur", LocalDate.of(2000, 4, 6), LocalDate.of(2020, 5, 10)));
        personsMap.put(2L, new PersonEntity(2L, "Ana Carolina", LocalDate.of(2001, 5, 8), LocalDate.now().plusDays(1L)));
        personsMap.put(3L, new PersonEntity(3L, "Fernanda Sousa", LocalDate.of(2002, 6, 9), LocalDate.now().plusDays(5L)));

        for (var i : personsMap.values()) {
            nextId =  nextId >= i.getId() ? nextId : i.getId();
            for (var j : personsMap.values()) {
                if (nextId < j.getId()) {
                    nextId = j.getId();
                }
            }
        }
    }

    public List<PersonEntity> findAll() {
        List<PersonEntity> entities = new ArrayList<>(personsMap.values());
        entities.sort(Comparator.comparing(PersonEntity::getName));
        return entities;
    }

    public PersonEntity add(final PersonEntity entity) {

        Long id = nextId + 1;

        if (entity.getId() != null) {
            id = entity.getId();
        }

        PersonEntity person = new PersonEntity(id, entity.getName(), entity.getDateBirth(), entity.getDateEmisson());
        personsMap.put(person.getId(), person);
        nextId = id;

        return person;
    }

    public PersonEntity update(final PersonEntity personEntity) {
        personsMap.put(personEntity.getId(), personEntity);
        return personEntity;
    }

    public Optional<PersonEntity> findById(final Long id) {
        return this.findAll().stream()
                .filter(entity -> entity.getId().equals(id))
                .findFirst();
    }

    public void delete(final Long id) {
        personsMap.remove(id);
    }

    public Boolean isExist(final Long id) {
        return personsMap.containsKey(id);
    }
}

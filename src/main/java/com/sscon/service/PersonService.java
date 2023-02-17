package com.sscon.service;

import com.sscon.entity.PersonEntity;
import com.sscon.entity.input.PersonInput;
import com.sscon.exception.*;
import com.sscon.repository.PersonRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {

    private final PersonRepository personRepository;

    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public List<PersonEntity> findAll() {
        return this.personRepository.findAll();
    }

    public PersonEntity add (final PersonEntity entity) {

        if (personRepository.isExist(entity.getId())) {
            throw new EntityExistException();
        }

        if (entity.getDateBirth() == null) {
            throw new DateBirthNullException();
        }

        if (entity.getDateEmisson() == null) {
            throw new DateEmissionNullException();
        }

        return personRepository.add(entity);
    }

    public PersonEntity findById(final Long id) {
        return personRepository
                .findById(id).orElseThrow(() -> new EntityNotFoundException(id));
    }

    public void delete(final Long id) {
        final PersonEntity person = findById(id);
        personRepository.delete(person.getId());
    }

    public PersonEntity update(final Long id, final PersonInput personInput) {
        if (!personRepository.isExist(id)) {
            throw new EntityNotFoundException(id);
        }

        final PersonEntity person = new PersonEntity(id, personInput.getName(), personInput.getDateBirth(), personInput.getDateEmisson());
        return personRepository.update(person);
    }

    public PersonEntity updateName(final Long id, final PersonInput personInput) {
        if (!personRepository.isExist(id)) {
            throw new EntityNotFoundException(id);
        }

        if (personInput.getId() != null) {
            throw new AttributeImmutableException("Id");
        }

        if (personInput.getDateEmisson() != null) {
            throw new AttributeImmutableException("Date of Emisson");
        }

        final PersonEntity personEntity = findById(id);

        return personRepository.update( new PersonEntity(id, personInput.getName(), personEntity.getDateBirth(), personEntity.getDateEmisson()));
    }
}

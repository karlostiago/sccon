package com.sscon.assembler;

import com.sscon.entity.PersonEntity;
import com.sscon.entity.dto.PersonDTO;
import org.springframework.stereotype.Component;

@Component
public class PersonAssembler extends Assembler<PersonDTO, PersonEntity> {

    @Override
    public PersonEntity toEntity(PersonDTO dto) {
        return new PersonEntity(dto.getId(), dto.getName(), dto.getDateBirth(), dto.getDateEmisson());
    }

    @Override
    public PersonDTO toDTO(PersonEntity entity) {
        return new PersonDTO(entity.getId(), entity.getName(), entity.getDateBirth(), entity.getDateEmisson());
    }
}

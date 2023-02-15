package com.sscon.entity.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.time.LocalDate;

public class PersonDTO {

    private Long id;
    private final String name;
    private final LocalDate dateBirth;
    private final LocalDate dateEmisson;

    public PersonDTO(final Long id, final String name, final LocalDate dateBirth, final LocalDate dateEmisson) {
        this.id = id;
        this.name = name;
        this.dateBirth = dateBirth;
        this.dateEmisson = dateEmisson;
    }

    public PersonDTO(final String name, final LocalDate dateBirth, final LocalDate dateEmisson) {
        this.name = name;
        this.dateBirth = dateBirth;
        this.dateEmisson = dateEmisson;
    }

    public String getName() {
        return name;
    }

    public LocalDate getDateBirth() {
        return dateBirth;
    }

    public LocalDate getDateEmisson() {
        return dateEmisson;
    }

    public Long getId() {
        return id;
    }
}

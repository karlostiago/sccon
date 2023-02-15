package com.sscon.entity;

import java.time.LocalDate;
import java.util.Objects;

public class PersonEntity {

    private Long id;
    private String name;
    private LocalDate dateBirth;
    private LocalDate dateEmisson;

    public PersonEntity(Long id, String name, LocalDate dateBirth, LocalDate dateEmisson) {
        this.id = id;
        this.name = name;
        this.dateBirth = dateBirth;
        this.dateEmisson = dateEmisson;
    }

    public Long getId() {
        return id;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final PersonEntity person = (PersonEntity) o;
        return id.equals(person.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}

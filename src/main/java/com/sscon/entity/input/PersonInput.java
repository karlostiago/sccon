package com.sscon.entity.input;

import java.time.LocalDate;

public class PersonInput {

    private Long id;
    private String name;
    private LocalDate dateBirth;
    private LocalDate dateEmisson;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDateBirth() {
        return dateBirth;
    }

    public void setDateBirth(LocalDate dateBirth) {
        this.dateBirth = dateBirth;
    }

    public LocalDate getDateEmisson() {
        return dateEmisson;
    }

    public void setDateEmisson(LocalDate dateEmisson) {
        this.dateEmisson = dateEmisson;
    }
}

package com.sscon.enumeration;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public enum Salary {

    MIN {
        @Override
        public BigDecimal execute(LocalDate dateEmisson) {
            final BigDecimal salaryMin = new BigDecimal(1302);
            final BigDecimal salary = calcSalary(dateEmisson);
            return salary.divide(salaryMin, RoundingMode.UP);
        }
    },
    FULL {
        @Override
        public BigDecimal execute(LocalDate dateEmisson) {
            return calcSalary(dateEmisson);
        }
    };

    BigDecimal calcSalary(LocalDate dateEmisson) {
        final LocalDate dateSystem = LocalDate.of(2023, 2, 7);

        BigDecimal salary = new BigDecimal(1558);

        final long years = ChronoUnit.YEARS.between(dateEmisson,dateSystem);

        for (int i = 0; i < years; i++) {
            double increase = (salary.doubleValue() * 0.18) + 500;
            salary = salary.add(BigDecimal.valueOf(increase));
        }

        return salary.setScale(2, RoundingMode.UP);
    }

    public abstract BigDecimal execute(LocalDate dateEmisson);
}

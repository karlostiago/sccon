package com.sscon.enumeration;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public enum Age {
    DAYS {
        @Override
        public Long execute(LocalDate dateBirth) {
            return calcAge(dateBirth, ChronoUnit.DAYS);
        }
    },
    MONTHS {
        @Override
        public Long execute(LocalDate dateBirth) {
            return calcAge(dateBirth, ChronoUnit.MONTHS);
        }
    },
    YEARS {
        @Override
        public Long execute(LocalDate dateBirth) {
            return calcAge(dateBirth, ChronoUnit.YEARS);
        }
    };

    Long calcAge(LocalDate dateBirth, ChronoUnit unit) {
        final LocalDate dateSystem = LocalDate.of(2023, 2, 7);
        return unit.between(dateBirth, dateSystem);
    }

    public abstract Long execute(LocalDate dateBirth);
}

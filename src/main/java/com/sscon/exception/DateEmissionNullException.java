package com.sscon.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class DateEmissionNullException extends RuntimeException {

    public DateEmissionNullException() {
        super("Date emission not be null");
    }
}

package com.sscon.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class AttributeImmutableException extends RuntimeException {

    public AttributeImmutableException(final String attributeName) {
        super("This is an immutable attribute and cannot be changed.: " + attributeName);
    }
}

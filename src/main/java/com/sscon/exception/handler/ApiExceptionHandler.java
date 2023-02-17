package com.sscon.exception.handler;

import com.sscon.exception.*;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDate;
import java.time.LocalTime;

@RestControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<?> handleEntityNotFoundException(EntityNotFoundException ex, WebRequest request) {
        final var problem = new Problem(HttpStatus.NOT_FOUND.value(), ex.getMessage(), LocalDate.now(), LocalTime.now(), getPath(request));
        return super.handleExceptionInternal(ex, problem, new HttpHeaders(), HttpStatus.NOT_FOUND, request);
    }

    @ExceptionHandler(EntityExistException.class)
    public ResponseEntity<?> handleEntityExistException(EntityExistException ex, WebRequest request) {
        final var problem = new Problem(HttpStatus.CONFLICT.value(), ex.getMessage(), LocalDate.now(), LocalTime.now(), getPath(request));
        return super.handleExceptionInternal(ex, problem, new HttpHeaders(), HttpStatus.CONFLICT, request);
    }

    @ExceptionHandler(AttributeImmutableException.class)
    public ResponseEntity<?> handleAttributeImmutableException(AttributeImmutableException ex, WebRequest request) {
        final var problem = new Problem(HttpStatus.BAD_REQUEST.value(), ex.getMessage(), LocalDate.now(), LocalTime.now(), getPath(request));
        return super.handleExceptionInternal(ex, problem, new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
    }

    @ExceptionHandler(DateEmissionNullException.class)
    public ResponseEntity<?> handleDataEmissionNullException(DateEmissionNullException ex, WebRequest request) {
        final var problem = new Problem(HttpStatus.BAD_REQUEST.value(), ex.getMessage(), LocalDate.now(), LocalTime.now(), getPath(request));
        return super.handleExceptionInternal(ex, problem, new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
    }

    @ExceptionHandler(DateBirthNullException.class)
    public ResponseEntity<?> handleDataBirthNullException(DateBirthNullException ex, WebRequest request) {
        final var problem = new Problem(HttpStatus.BAD_REQUEST.value(), ex.getMessage(), LocalDate.now(), LocalTime.now(), getPath(request));
        return super.handleExceptionInternal(ex, problem, new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
    }

    private String getPath(final WebRequest request) {
        return ((ServletWebRequest) request).getRequest().getRequestURI();
    }
}

package com.sscon.exception.handler;

import java.time.LocalDate;
import java.time.LocalTime;

public class Problem {

    private final int status;
    private final String message;
    private final LocalDate date;
    private final LocalTime time;
    private final String path;

    public Problem(int status, String message, LocalDate date, LocalTime time, String path) {
        this.status = status;
        this.message = message;
        this.date = date;
        this.time = time;
        this.path = path;
    }

    public int getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

    public LocalDate getDate() {
        return date;
    }

    public LocalTime getTime() {
        return time;
    }

    public String getPath() {
        return path;
    }
}

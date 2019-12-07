package com.robosh.model.exception;

public class NoSuchCourseException extends RuntimeException {
    public NoSuchCourseException() {
    }

    public NoSuchCourseException(String message) {
        super(message);
    }

    public NoSuchCourseException(String message, Throwable cause) {
        super(message, cause);
    }

    public NoSuchCourseException(Throwable cause) {
        super(cause);
    }

    public NoSuchCourseException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}

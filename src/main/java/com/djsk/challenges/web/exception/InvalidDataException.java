package com.djsk.challenges.web.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value= HttpStatus.NOT_ACCEPTABLE, reason="given data value is incorrect")
public class InvalidDataException extends RuntimeException {

    public InvalidDataException() {
        super();
    }

    public InvalidDataException(final String message, final Throwable cause) {
        super(message, cause);
    }

    public InvalidDataException(final String message) {
        super(message);
    }

    public InvalidDataException(final Throwable cause) {
        super(cause);
    }
}

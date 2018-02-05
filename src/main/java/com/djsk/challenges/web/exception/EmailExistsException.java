package com.djsk.challenges.web.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value= HttpStatus.CONFLICT, reason="user already exists")
public class EmailExistsException extends RuntimeException {

    public EmailExistsException() {
        super();
    }

    public EmailExistsException(final String message, final Throwable cause) {
        super(message, cause);
    }

    public EmailExistsException(final String message) {
        super(message);
    }

    public EmailExistsException(final Throwable cause) {
        super(cause);
    }
}

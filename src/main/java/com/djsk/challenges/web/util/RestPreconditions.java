package com.djsk.challenges.web.util;

import com.djsk.challenges.web.exception.ResourceAlreadyExistsException;
import com.djsk.challenges.web.exception.ResourceNotFoundException;

public final class RestPreconditions {

    private RestPreconditions() {
        throw new AssertionError();
    }

    public static <T> T checkFound(final T resource) {
        if (resource == null) {
            throw new ResourceNotFoundException();
        }
        return resource;
    }

    public static <T> T checkNotExists(final T resource) {
        if (resource != null) {
            throw new ResourceAlreadyExistsException();
        }

        return resource;
    }

}

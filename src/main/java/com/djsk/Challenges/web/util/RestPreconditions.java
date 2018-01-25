package com.djsk.Challenges.web.util;

import com.djsk.Challenges.web.exception.ResourceAlreadyExistsException;
import com.djsk.Challenges.web.exception.ResourceNotFoundException;

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

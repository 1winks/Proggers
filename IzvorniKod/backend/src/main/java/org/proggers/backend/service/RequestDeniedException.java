package org.proggers.backend.service;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Returns 400 BadRequest
 */
@ResponseStatus(HttpStatus.BAD_REQUEST)
public class RequestDeniedException extends RuntimeException {
    public RequestDeniedException(String message) {
        super(message);
    }
}
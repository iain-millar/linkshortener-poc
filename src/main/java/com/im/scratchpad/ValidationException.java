package com.im.scratchpad;

/**
 * Simple exception wrapper to highlight a validation
 * exception use case.
 */
public class ValidationException extends Exception {
    public ValidationException(String errorMessage) {
        super(errorMessage);
    }
}

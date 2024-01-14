package com.im.scratchpad;
/**
 * Simple exception wrapper to highlight a exception
 * when attempting to find a shortened URL.
 */
public class NoLinkFoundException extends Exception {

    public NoLinkFoundException(String errorMessage) {
        super(errorMessage);
    }
}

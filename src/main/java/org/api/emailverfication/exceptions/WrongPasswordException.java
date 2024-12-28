package org.api.emailverfication.exceptions;

public class WrongPasswordException extends RuntimeException {

    // Wrong password exception
    public WrongPasswordException(String message) {
        super(message);
    }
}

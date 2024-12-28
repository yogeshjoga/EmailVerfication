package org.api.emailverfication.exceptions;

public class WrongUserNameException extends RuntimeException {

    // Wrong username Exception
    public WrongUserNameException(String message) {
        super(message);
    }
}

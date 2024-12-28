package org.api.emailverfication.exceptions;

public class UserNotFoundException extends RuntimeException {

    // User not Found exception
    public UserNotFoundException(String message) {
        super(message);
    }
}

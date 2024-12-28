package org.api.emailverfication.exceptions;

public class WrongOTPException extends RuntimeException {

    // Wrong OTP Exception
    public WrongOTPException(String message) {
        super(message);
    }
}

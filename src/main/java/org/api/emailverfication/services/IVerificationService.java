package org.api.emailverfication.services;

import org.api.emailverfication.constents.VERIFIED;

public interface IVerificationService {
    void sendVerificationEmail(String email);
    VERIFIED verifyOTP(String otp, String email);
}

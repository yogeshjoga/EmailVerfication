package org.api.emailverfication.services.verificationservice;

import org.api.emailverfication.constents.VERIFIED;

public interface IVerificationService {
    Boolean sendVerificationEmail(String email);
    VERIFIED verifyOTP(String otp, String email);
}

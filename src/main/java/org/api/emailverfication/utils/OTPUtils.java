package org.api.emailverfication.utils;

import org.springframework.stereotype.Component;

import java.security.SecureRandom;

@Component
public class OTPUtils {

    private static final SecureRandom SECURE_RANDOM = new SecureRandom();
    private static int OTP_LENGTH = 6;

    public static String generateOTP() {
        StringBuilder otp = new StringBuilder();
        for (int i = 0; i < OTP_LENGTH; i++) {
            otp.append(SECURE_RANDOM.nextInt(10));
        }
        return otp.toString();
    }
}

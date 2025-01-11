package org.api.emailverfication.services.otpservice;

import org.api.emailverfication.models.OTP;

public interface IOTPService {
     boolean isValid(OTP otp);
     OTP generateOTP(String email);
}

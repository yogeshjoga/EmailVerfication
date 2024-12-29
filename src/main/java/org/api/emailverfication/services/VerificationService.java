package org.api.emailverfication.services;

import org.api.emailverfication.constents.VERIFIED;
import org.api.emailverfication.models.OTP;
import org.api.emailverfication.repo.OTPRepo;
import org.api.emailverfication.utils.OTPUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class VerificationService {

    @Autowired
    private OTPRepo otpRepo;

    @Autowired
    private EmailService emailService;

    public VERIFIED verifyOTP(String otp, String email) {
        String newOtp = otpRepo.getOTPByEmail(email).toString();
        if (newOtp.equals(otp)) {
            otpRepo.deleteOTPByEmail(email);
            return VERIFIED.VERIFIED;
        }
        return VERIFIED.NOT_VERIFIED;
    }

   public void sendVerificationEmail(String email) {
        String OTP = OTPUtils.generateOTP();
        OTP otp = new OTP();
        otp.setId(UUID.randomUUID());
        otp.setOtp(OTP);
        otp.setEmail(email);
        OTP newOTP = otpRepo.save(otp);
        String subject = "Verification Email";
        emailService.sendEmail(email, subject, newOTP.getOtp());
   }
}

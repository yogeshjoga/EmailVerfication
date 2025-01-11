package org.api.emailverfication.services.verificationservice;

import org.api.emailverfication.services.otpservice.IOTPService;
import org.api.emailverfication.utils.EmailOTPTemplete;
import org.api.emailverfication.constents.VERIFIED;
import org.api.emailverfication.models.OTP;
import org.api.emailverfication.models.User;
import org.api.emailverfication.repo.OTPRepo;
import org.api.emailverfication.repo.UserRepo;
import org.api.emailverfication.services.emailservice.IEmailService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service("verificationService")
public class VerificationService implements IVerificationService {

    @Autowired
    private OTPRepo otpRepo;

    @Autowired
    private IEmailService emailService;

    @Autowired
    private IOTPService otpService;

    private static final Logger log = LoggerFactory.getLogger(VerificationService.class);

    @Autowired
    private UserRepo userRepo;


    @Override
    public VERIFIED verifyOTP(String email, String otp) {
        String newOtp = otpRepo.getOTPByEmail(email);
        OTP otpValid = otpRepo.findByOtp(email);
        if (newOtp.equals(otp) && otpService.isValid(otpValid)) {
            otpRepo.deleteOTPByEmail(email);
            User user = userRepo.findByUser(email);
            user.setIsVerified(VERIFIED.VERIFIED);
            userRepo.save(user);
            return VERIFIED.VERIFIED;
        }
        return VERIFIED.NOT_VERIFIED;
    }


    @Override
   public Boolean sendVerificationEmail(String email) {
        // setting Subject to email
        String subject = "Verification Email OTP";
        log.info("calling SendVerificationEmail to " + email);
        // Getting the email template from utils
        OTP newOtp = otpService.generateOTP(email);
        String body = EmailOTPTemplete.generateEmailTemplete(email, newOtp.getOtp());
        return emailService.sendEmail1(email, subject, body );

   }

}

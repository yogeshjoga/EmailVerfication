package org.api.emailverfication.services.verificationservice;

import org.api.emailverfication.constents.VERIFIED;
import org.api.emailverfication.models.OTP;
import org.api.emailverfication.models.User;
import org.api.emailverfication.repo.OTPRepo;
import org.api.emailverfication.repo.UserRepo;
import org.api.emailverfication.services.emailservice.IEmailService;
import org.api.emailverfication.utils.OTPUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.UUID;

@Service("verificationService")
public class VerificationService implements IVerificationService {

    @Autowired
    private OTPRepo otpRepo;

    @Autowired
    private IEmailService emailService;

    private static final Logger log = LoggerFactory.getLogger(VerificationService.class);
    @Autowired
    private UserRepo userRepo;


    @Override
    public VERIFIED verifyOTP(String email, String otp) {
        String newOtp = otpRepo.getOTPByEmail(email);
        if (newOtp.equals(otp)) {
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


        log.info("Sending verification email to " + email);
        String OTP = OTPUtils.generateOTP();
        OTP otp = new OTP();
        log.info("crated OTP: " + otp);
        otp.setId(UUID.randomUUID());
        otp.setOtp(OTP);
        otp.setEmail(email);
        log.info("OTP saved into otpRepo " + otp);
        OTP newOTP = otpRepo.save(otp);
        String subject = "Verification Email OTP";
        log.info("calling SendVerificationEmail to " + email);

        String body = "<html>" +
                "<body>" +
                "<p>Dear Email Verification User,</p>" +
                "<p>Your Email verify Account (Email is: <b>" + email.substring(0, 4) + "*******@gmail.com</b>).</p>" +
                "<p>Your One Time PIN is: <b> <span style ='font-size: 32px;'>" + newOTP.getOtp() + "</span></b>, and it is valid for 10 minutes.</p>" +
                "<p><small>(Generated at " + new Date().toString() + ")</small></p>" +
                "<hr>" +
                "<p><i>This is an auto-generated email. Please do not reply to this email.</i></p>" +
                "</body>" +
                "</html>";


        //String body = "Hello Venky how are you today? This is a verification email OTP don't send orthers " +  newOTP.getOtp();
        return emailService.sendEmail1(email, subject, body );//newOTP.getOtp());

   }

}

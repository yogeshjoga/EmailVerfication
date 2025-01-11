package org.api.emailverfication.services.otpservice;

import org.api.emailverfication.models.OTP;
import org.api.emailverfication.repo.OTPRepo;
import org.api.emailverfication.utils.OTPUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.UUID;

@Service
public class OTPService implements  IOTPService {

    @Autowired
    private OTPRepo otpRepo;

    private static final Logger log = LoggerFactory.getLogger(OTPService.class);

    @Override
    public boolean isValid(OTP otp) {
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime createdTime = otp.getCreatedAt();
        Duration duration = Duration.between(createdTime, now);
        return duration.toMinutes() < 10;
    }

    @Override
    public OTP generateOTP(String email) {

        // Before sending new OTP clear old OTP's
        if(otpRepo.findByEmail(email)){
            otpRepo.deleteOTPByEmail(email);
        }
        // If not presented create a new OTP and send to user email
        OTP otp = new OTP();
        log.info("crated OTP: " + otp);
        otp.setId(UUID.randomUUID());
        otp.setEmail(email);
        otp.setCreatedAt(LocalDateTime.now());
        otp.setOtp(OTPUtils.generateOTP());

        log.info("OTP saved into otpRepo " + otp);
        // newOTP
       return otpRepo.save(otp);
    }


}

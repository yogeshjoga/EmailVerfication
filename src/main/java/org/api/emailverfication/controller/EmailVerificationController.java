package org.api.emailverfication.controller;

import org.api.emailverfication.constents.VERIFIED;
import org.api.emailverfication.exceptions.WrongOTPException;
import org.api.emailverfication.services.VerificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/auth/")
public class EmailVerificationController {

    @Autowired
    private VerificationService verificationService;

    @PostMapping("/send-verification")
    public ResponseEntity<String> sendVerificationEmail(@RequestParam String email) {
        verificationService.sendVerificationEmail(email);
        return ResponseEntity.status(200).body("Email sent");
    }

    @GetMapping("/verify")
    public ResponseEntity<VERIFIED> verifyEmail(@RequestParam String email, @RequestParam String otp) {
        VERIFIED isVerified = verificationService.verifyOTP(email, otp);
        if (isVerified == null || isVerified == VERIFIED.NOT_VERIFIED) {
            throw new WrongOTPException("Wrong OTP");
        }
        return ResponseEntity.ok(isVerified);
    }
}

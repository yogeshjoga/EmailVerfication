package org.api.emailverfication.controller;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import org.api.emailverfication.constents.VERIFIED;
import org.api.emailverfication.exceptions.WrongOTPException;
import org.api.emailverfication.services.verificationservice.IVerificationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/api/v1/auth/")
public class EmailVerificationController {

    @Autowired
    private IVerificationService verificationService;

    private static final Logger log = LoggerFactory.getLogger(EmailVerificationController.class);

   private MultiValueMap<String, String> headers;

    @PostMapping("/send/{email}")
    public ResponseEntity<String> sendVerificationEmail(@PathVariable("email") String email, HttpServletResponse response) {
        // cookies
        Cookie cookie = new Cookie("email", email);
        cookie.setPath("/");
        cookie.setMaxAge(0);
        cookie.setHttpOnly(true);
        response.addCookie(cookie);
        // headers
        headers = new LinkedMultiValueMap<>();
        headers.add("Content-Type", "application/json");
        headers.add("this for send verification mail", "that's it");
        log.info("Sending verification email to " + email);

       // verificationService.sendVerificationEmail(email)
        if(!verificationService.sendVerificationEmail(email)){
            log.info("Verification email Not sent INTERNAL_SERVER_ERROR");
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }else{
            log.info("Verification email sent OK");
            return new ResponseEntity<>("Verification email sent",headers , HttpStatus.OK);
        }

    }

    @GetMapping("/verify")
    public ResponseEntity<VERIFIED> verifyEmail(@RequestParam String email, @RequestParam String otp) {
        VERIFIED isVerified = verificationService.verifyOTP(email, otp);
        if (isVerified == null || isVerified == VERIFIED.NOT_VERIFIED) {
            throw new WrongOTPException("Wrong OTP or OTP Time exceeded Please try again");
        }
        return ResponseEntity.ok(isVerified);
    }
}

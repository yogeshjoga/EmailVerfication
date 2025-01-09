package org.api.emailverfication.controller;


import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import org.api.emailverfication.services.IVerificationService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;

@SpringBootTest
public class TestEmailVerificationController {

    private static final Logger log = LoggerFactory.getLogger(TestEmailVerificationController.class);

    @InjectMocks
    private EmailVerificationController emailVerificationController;

    @Mock
    private IVerificationService verificationService;

    @Mock
    private HttpServletResponse response;

    @BeforeEach
    public void setUp(){
        MockitoAnnotations.initMocks(this);
    }


    @Test
    @Tag("Uint Testing")
    @DisplayName("Testing the Send verification email to user to verify the email by using OTP auth")
    public void testSendVerificationEmail() {
        String email = "test@example.com";
        ResponseEntity<String> responseEntity = emailVerificationController.sendVerificationEmail(email, response);

        verify(response).addCookie(any(Cookie.class));
        verify(verificationService).sendVerificationEmail(email);

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals("Verification email sent", responseEntity.getBody());

        log.info(responseEntity.getBody());
        log.info("Email verified successfully");
        log.info("Test successfully verified");

    }


}

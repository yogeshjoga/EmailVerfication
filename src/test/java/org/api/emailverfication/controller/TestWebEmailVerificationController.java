package org.api.emailverfication.controller;


import com.fasterxml.jackson.databind.ObjectMapper;
import org.api.emailverfication.services.verificationservice.IVerificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;

@WebMvcTest(EmailVerificationController.class)
public class TestWebEmailVerificationController {

    @MockBean
    private IVerificationService verificationService;

    @Autowired
    private ObjectMapper objectMapper;



    // let's write a test case for sendVerificationEmail controller method
    // path is /api/v1/auth/send/{email}
    // you need to pass HttpServletResponse cookies
    // Arrange Act Assert

    public void testSendOtpEmail()throws Exception{
        // Arrange
        String email = "test@emailverfication.com";
        String otp = "123456";


    }

}

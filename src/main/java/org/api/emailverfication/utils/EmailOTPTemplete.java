package org.api.emailverfication.utils;

import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class EmailOTPTemplete {



    public static String generateEmailTemplete(String email, String otp) {

          return "<html>" +
                "<body>" +
                "<p>Dear Email Verification User,</p>" +
                "<p>Your Email verify Account (Email is: <b>" + email.substring(0, 4) + "*******@gmail.com</b>).</p>" +
                "<p>Your One Time PIN is: <b> <span style ='font-size: 32px;'>" + otp + "</span></b>, and it is valid for 10 minutes.</p>" +
                "<p><small>(Generated at " + new Date().toString() + ")</small></p>" +
                "<hr>" +
                "<p><i>This is an auto-generated email. Please do not reply to this email.</i></p>" +
                "</body>" +
                "</html>";
    }




}

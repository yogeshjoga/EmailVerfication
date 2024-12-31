package org.api.emailverfication.services;

import org.api.emailverfication.controller.EmailVerificationController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service("emailService")
public class EmailService {


    @Autowired
    private JavaMailSender mailSender;

    private static final Logger log = LoggerFactory.getLogger(EmailService.class);

    public Boolean sendEmail(String to, String subject, String body) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(to);
        message.setFrom("jogayogesh39@gmail.com");
        message.setCc("jogayogesh39@gmail.com");
        message.setBcc("jogayogesh39@gmail.com");
        message.setSubject(subject);
        message.setText(body);
        try{
            mailSender.send(message);
            return true;
        }catch(Exception e){
            return false;
        }
    }


}

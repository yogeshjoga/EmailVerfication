package org.api.emailverfication.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {


    @Autowired
    private JavaMailSender mailSender;

    public void sendEmail(String to, String subject, String body) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(to);
        message.setFrom("jogayogesh39@gmail.com");
        message.setCc("jogayogesh39@gmail.com");
        message.setBcc("jogayogesh39@gmail.com");
        message.setSubject(subject);
        message.setText(body);
        mailSender.send(message);
    }


}

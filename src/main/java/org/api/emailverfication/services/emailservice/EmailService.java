package org.api.emailverfication.services.emailservice;

import jakarta.mail.internet.MimeMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service("emailService")
public class EmailService implements IEmailService {


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


    public Boolean sendEmail1(String to, String subject, String body) {
        try {
            MimeMessage message = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true, "UTF-8");
            helper.setTo(to); helper.setFrom("jogayogesh39@gmail.com");
            helper.setCc("jogayogesh39@gmail.com");
            helper.setBcc("jogayogesh39@gmail.com");
            helper.setSubject(subject);
            helper.setText(body, true);
            mailSender.send(message);
            return true;
        } catch (Exception e) {
            return false;
        }
    }


}

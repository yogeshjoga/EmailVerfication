package org.api.emailverfication.services.emailservice;

public interface IEmailService {
    Boolean sendEmail(String to, String subject, String body);
    Boolean sendEmail1(String to, String subject, String body);
}

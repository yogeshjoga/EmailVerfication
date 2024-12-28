package org.api.emailverfication.services;

public interface IEmailService {
    void sendEmail(String to, String subject, String body);
}

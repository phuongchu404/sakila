package com.film.service;

import jakarta.mail.MessagingException;
import org.thymeleaf.context.Context;

public interface EmailService {
    void sendEmail(String to, String subject, String template, Context context) throws MessagingException;
    String sendSimpleMail(String to, String subject, String template);
    void sendEmailForgotPassword(String to, String subject, String template, String link) throws MessagingException;
}

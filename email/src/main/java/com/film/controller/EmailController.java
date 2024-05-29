package com.film.controller;

import com.film.request.EmailRequest;
import com.film.service.EmailService;
import jakarta.mail.MessagingException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.thymeleaf.context.Context;

@RestController
@RequestMapping("/email")
@Slf4j
public class EmailController {
    @Autowired
    private EmailService emailService;

    @PostMapping("/send")
    public ResponseEntity sendEmail(@RequestBody EmailRequest emailRequest)  {
        Context context = new Context();
        context.setVariable("name", emailRequest.getName());
        context.setVariable("message", emailRequest.getMessage());
        context.setVariable("subject", emailRequest.getSubject());
        try {
            emailService.sendEmail(emailRequest.getTo(), emailRequest.getSubject(), "emailTemplate", context);
        }catch (Exception e) {
            log.error("Sending email error: {}", e.getMessage());
        }

        return ResponseEntity.ok("Email sent successfully");
    }
}

package com.film.controller;

import com.film.entity.User;
import com.film.request.MailForgotPassword;
import com.film.request.ResetPassword;
import com.film.response.ResetPasswordResponse;
import com.film.service.EmailService;
import com.film.service.UserService;
import com.film.utils.Utility;
import jakarta.mail.MessagingException;
import jakarta.servlet.http.HttpServletRequest;
import org.modelmapper.internal.bytebuddy.utility.RandomString;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.thymeleaf.standard.expression.MessageExpression;

import java.net.URI;
import java.util.Random;

@Controller
@RequestMapping
public class ForgotPasswordController {
    private static final Logger log = LoggerFactory.getLogger(ForgotPasswordController.class);
    @Autowired
    private UserService userService;

    @Autowired
    private EmailService emailService;

//    @GetMapping("/forgot-password")
//    public String showForgotPassword(){
//        return "forgot_password_form";
//    }

    @PostMapping("/forgot-password")
    public ResponseEntity processForgotPassword(HttpServletRequest request, @RequestBody MailForgotPassword mailForgotPassword) {
        String email = mailForgotPassword.getEmail();
        String token = RandomString.make(30);
            userService.updateResetPasswordToken(token, email);
            String resetPasswordLink = Utility.getSiteURL(request) + "/reset-password?token=" + token;
            try {
                emailService.sendEmailForgotPassword(email, "Reset Password","mail_reset_password", resetPasswordLink);

            }catch (MessagingException e) {
                log.error("Error sending email: {}", e.getMessage());
            }

        return ResponseEntity.ok("Send to email forgot password successfully");
    }

    @GetMapping("/reset-password")
    public ResponseEntity showResetPasswordForm(@RequestParam(value = "token") String token) {
        User user = userService.getByResetPasswordToken(token);
        if(user == null){
            return ResponseEntity.badRequest().body("Invalid token");
        }
//        HttpHeaders headers = new HttpHeaders();
//        headers.setLocation(URI.create("https://www.google.com"));
//        return new ResponseEntity<>(headers, HttpStatus.MOVED_PERMANENTLY);
        Random random = new Random();
        StringBuilder sb = new StringBuilder();
        for(int i=0; i< 6; i++) {
            int digit = random.nextInt(10);
            sb.append(digit);
        }
        ResetPasswordResponse response = new ResetPasswordResponse(token, sb.toString());
        return new ResponseEntity(response, HttpStatus.OK);
    }
    @PostMapping("/reset-password")
    public ResponseEntity processResetPassword(@RequestBody ResetPassword resetPassword){
        User user= userService.getByResetPasswordToken(resetPassword.getToken());
        if(user==null){
            log.error("invalid token");
            return ResponseEntity.badRequest().body("Invalid token");
        }else{
            userService.updatePassword(user,resetPassword.getPassword());
            return ResponseEntity.ok("You have successfully changed your password");
        }
    }


}

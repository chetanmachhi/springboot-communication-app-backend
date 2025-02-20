package com.example.demo.service;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;

import java.util.Properties;

@Service
public class EmailService {

    // Configuring the JavaMailSender bean
    @Bean
    public JavaMailSender javaMailSender() {
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost("smtp.gmail.com");  // SMTP host for Gmail
        mailSender.setPort(587);               // Port for TLS (587 for Gmail)
        mailSender.setUsername("cjmachhi00@gmail.com");  // Your Gmail address
        mailSender.setPassword("jbkj gmtq deda iakb\n");     // Your generated app password

        // Set properties for the SMTP connection
        Properties props = mailSender.getJavaMailProperties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");  // Enable TLS
        props.put("mail.smtp.ssl.trust", "smtp.gmail.com");
        props.put("mail.smtp.connectiontimeout", "5000");
        props.put("mail.smtp.timeout", "5000");

        return mailSender;
    }

    // Method to send an email
    public void sendEmail(String to, String subject, String message) {
        SimpleMailMessage email = new SimpleMailMessage();
        email.setFrom("cjmachhi00@gmail.com");  // Replace with your email
        email.setTo(to);
        email.setSubject(subject);
        email.setText(message);
        javaMailSender().send(email);  // Send the email
        System.out.println("Email sent successfully to " + to);
    }
}

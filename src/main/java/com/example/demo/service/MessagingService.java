package com.example.demo.service;

import com.example.demo.model.Recipient;
import com.example.demo.util.CsvUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class MessagingService {

    @Autowired
    private EmailService emailService;

    /**
     * Bulk processing: read CSV file and send emails one by one.
     * The CSV file should have columns: to,subject,message.
     */
    public void processBulk(MultipartFile file) {
        try {
            List<Recipient> recipients = CsvUtil.parse(file);
            for (Recipient recipient : recipients) {
                // Send the email using EmailService instead of just logging.
                emailService.sendEmail(
                        recipient.getContact(),  // Recipient's email address
                        recipient.getSubject(),  // Email subject
                        recipient.getMessage()   // Email message body
                );
            }
        } catch (IOException e) {
            System.err.println("Error processing CSV: " + e.getMessage());
        }
    }

    /**
     * Sends a message (email) for a given recipient.
     * In a real application, you might switch between different messaging channels.
     */
    public void sendMessage(Recipient recipient) {
        emailService.sendEmail(
                recipient.getContact(),
                recipient.getSubject(),
                recipient.getMessage()
        );
    }
}

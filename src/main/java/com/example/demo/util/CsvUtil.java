package com.example.demo.util;

import com.example.demo.model.Recipient;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

// A basic CSV parser that reads lines and splits them by comma.
// Assumes CSV rows with three columns: contact,subject,message
public class CsvUtil {

    public static List<Recipient> parse(MultipartFile file) throws IOException {
        List<Recipient> recipients = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(file.getInputStream()))) {
            String line;
            // Skip header row
            reader.readLine(); // Discard the first line (header)
            while ((line = reader.readLine()) != null) {
                String[] fields = line.split(",");
                if (fields.length >= 3) {
                    String contact = fields[0].trim();
                    String subject = fields[1].trim();
                    String message = fields[2].trim();

                    // Validate the email address format
                    if (isValidEmail(contact)) {
                        recipients.add(new Recipient(contact, subject, message));
                    } else {
                        System.err.println("Invalid email address skipped: " + contact);
                    }
                }
            }
        }
        return recipients;
    }

    private static boolean isValidEmail(String email) {
        // Simple regex for basic email validation (adjust as needed)
        return email.matches("^[\\w.-]+@[\\w.-]+\\.[A-Za-z]{2,}$");
    }
}

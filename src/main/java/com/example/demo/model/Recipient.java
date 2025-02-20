package com.example.demo.model;

// A simple POJO to represent a recipient with contact info and a message.
public class Recipient {
    private String contact; // Email or phone number
    private String subject; // Email subject
    private String message; // Message content

    // No-argument constructor (needed for frameworks like Spring)
    public Recipient() {
    }

    // Constructor with all fields
    public Recipient(String contact, String subject, String message) {
        this.contact = contact;
        this.subject = subject;
        this.message = message;
    }

    // Getters and setters
    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }
}

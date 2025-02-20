package com.example.demo.controller;

import com.example.demo.model.Recipient;
import com.example.demo.service.MessagingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api")
public class Controller {

    @Autowired
    private MessagingService messagingService;

    // Bulk messaging endpoint:
    // Expects a CSV file upload with recipient data.
    @PostMapping("/bulk")
    public ResponseEntity<String> bulkUpload(@RequestParam("file") MultipartFile file) {
        messagingService.processBulk(file);
        return ResponseEntity.ok("Bulk processing initiated");
    }

    // Real-time messaging endpoint:
    // Expects a JSON payload with 'contact' and 'message'.
    @PostMapping("/send")
    public ResponseEntity<String> sendMessage(@RequestBody Recipient recipient) {
        messagingService.sendMessage(recipient);
        return ResponseEntity.ok("Message sent");
    }
}

package com.example.demo.controller;

import com.example.demo.service.TwilioCallService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

// Class to receive the phone number data in JSON format
class CallRequest {
    private String to;

    // Getter and Setter
    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }
}

@RestController
public class TwilioController {

    // Injecting TwilioCallService to call the makeCall method
    @Autowired
    private TwilioCallService twilioCallService;

    // Endpoint to trigger a call
    @PostMapping("/make-call")
    public String makeCall(@RequestBody CallRequest callRequest) {
        try {
            // Call the method from TwilioCallService to initiate the call
            twilioCallService.makeCall(callRequest.getTo());
            return "Call initiated successfully!";
        } catch (Exception e) {
            return "Error initiating call: " + e.getMessage();
        }
    }
}

package com.example.demo.service;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Call;
import com.twilio.type.PhoneNumber;
import java.net.URI;
import org.springframework.stereotype.Service;


@Service
public class TwilioCallService {

    // Initialize 'from' number here
    private static final String FROM_NUMBER = "+18154291771";  // Your Twilio number
    private static final String ACCOUNT_SID = "AC2a6f68ecde76df9280f51dfc0c7dcbd3";
    private static final String AUTH_TOKEN = "b123105c93466ea7a23f60976c49b239";

    // Initialize Twilio
    static {
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
    }

    // Method to initiate the call
    public static void makeCall(String to) {
        try {
            // Use the initialized 'from' number
            Call call = Call.creator(
                            new PhoneNumber(to),
                            new PhoneNumber(FROM_NUMBER),
                            URI.create("http://demo.twilio.com/docs/voice.xml"))
                    .create();

            System.out.println("Call initiated: " + call.getSid());
        } catch (Exception e) {
            System.out.println("Error making call: " + e.getMessage());
        }
    }
}

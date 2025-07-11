package com.example.emailservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController

public class EmailController {
    private static final Logger logger = LoggerFactory.getLogger(EmailController.class);

    @Autowired
    private EmailService emailService;

    @PostMapping("/api/email/send")
    public String sendEmail(@RequestParam("email") String email, @RequestParam("to") String to) {
        logger.info("Received request: email={}, to={}", email, to);
        boolean success = emailService.sendEmail(email, to);
        return success ? "Email sent successfully" : "Failed to send email";
    }
    
    @GetMapping("/api/email/send")
    public ResponseEntity<String> welcome() {
        return ResponseEntity.ok("Welcome to Email Service API");
    }
}
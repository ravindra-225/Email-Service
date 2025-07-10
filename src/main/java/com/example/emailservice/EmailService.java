package com.example.emailservice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class EmailService {
	private static final Logger logger = LoggerFactory.getLogger(EmailService.class);
    private static final int MAX_ATTEMPTS = 3;

    public boolean sendEmail(String email, String to) {
        if (email == null || email.trim().isEmpty() || to == null || to.trim().isEmpty()) {
            logger.error("Invalid input: email or recipient cannot be empty");
            return false;
        }

        for (int attempt = 1; attempt <= MAX_ATTEMPTS; attempt++) {
            logger.info("Attempt {} to send email to {}", attempt, to);
            if (sendMockEmail(email, to)) {
                logger.info("Email sent successfully to {}", to);
                return true;
            }
            logger.warn("Failed to send email to {}. Retrying...", to);
            try { Thread.sleep(1000); } catch (InterruptedException e) { Thread.currentThread().interrupt(); }
        }
        logger.error("Failed to send email to {} after {} attempts", to, MAX_ATTEMPTS);
        return false;
    }

    private boolean sendMockEmail(String email, String to) {
        return Math.random() > 0.3; 
    }
}


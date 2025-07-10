package com.example.emailservice;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class EmailServiceTest {
	@Autowired
	private EmailService emailService;

	@Test
    void testSendEmailSuccess() {
	boolean result = emailService.sendEmail("Test email", "user@example.com");
    assertTrue(result); // May vary due to random mock, but should succeed sometimes
}

	@Test
	void testSendEmailInvalidInput() {
		boolean result = emailService.sendEmail("", "");
		assertFalse(result);
	}
}


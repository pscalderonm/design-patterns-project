package com.design.patterns.project.service.impl;

import com.design.patterns.project.service.EmailNotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailNotificationServiceImpl implements EmailNotificationService {

    @Autowired
    private JavaMailSender mailSender;

    @Value("${app.mail.sender}")
    private String emailSender;

    @Override
    public void notify(String destinyEmail, String emailSubject, String emailBody) {

        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(emailSender);
        message.setTo(destinyEmail);
        message.setSubject(emailSubject);
        message.setText(emailBody);

        mailSender.send(message);

    }
}

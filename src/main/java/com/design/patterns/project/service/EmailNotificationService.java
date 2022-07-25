package com.design.patterns.project.service;

public interface EmailNotificationService {
    void notify(String destinyEmail, String emailSubject, String emailBody);
}

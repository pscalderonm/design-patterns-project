package com.design.patterns.project.events;

import com.design.patterns.project.models.Employee;
import com.design.patterns.project.service.EmailNotificationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

import java.util.Objects;

public class EmployeeCreatedForEmailNotifySubscriber implements Subscriber {

    private final static Logger log = LoggerFactory.getLogger(EmployeeCreatedForEmailNotifySubscriber.class);
    private final static String MESSAGE_PATTERN = "Dear %s:\nYou have been registered into our internal platform for vacuum doses tracking.\n" +
            "Now you can manage your profile\nHave a Good day :)";

    private final static String MESSAGE_SUBJECT = "Account Register Notification";

    private final EmailNotificationService emailNotificationService;

    public EmployeeCreatedForEmailNotifySubscriber(EmailNotificationService emailNotificationService){
        this.emailNotificationService = emailNotificationService;
    }

    @Override
    public void notify(String event, Object args) {
        Employee employee = (Employee) args;
        if(!Objects.equals(event, EventConstants.ON_EMPLOYEE_CREATED) || employee == null || StringUtils.isEmpty(employee.getEmail())){
            return;
        }

        String message = String.format(MESSAGE_PATTERN, String.format("%s %s",
                employee.getFirstName(), employee.getLastName()));

        log.info("Preparing to send email notification...");
        emailNotificationService.notify(employee.getEmail(), MESSAGE_SUBJECT, message);
        log.info("Email notification sent");
    }
}

package com.design.patterns.project.events;

import com.design.patterns.project.service.EmailNotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Component
public class EmployeeCreatedEmailNotifierSubscriber {

    private final static Logger log = LoggerFactory.getLogger(EmployeeCreatedEmailNotifierSubscriber.class);

    private final static String MESSAGE_PATTERN = "Dear %s:\n You have been registered into our internal platform for vacuum doses tracking.\n" +
            "Now you can manage your profile\n Have a Good day :)";

    private final static String MESSAGE_SUBJECT = "Account Register Notification";

    @Autowired
    private EmailNotificationService notificationService;

    @EventListener
    public void handleEmployeeCreatedEvent(final EmployeeCreatedEvent args){

        if(args == null || args.getEmployeeEmail().isEmpty()){
            log.info("Newly created employee has no email, therefore, no notification will be sent.");
            return;
        }

        String message = String.format(MESSAGE_PATTERN, args.getEmployeeFullName());

        log.info("Preparing to send email notification...");
        notificationService.notify(args.getEmployeeEmail(), MESSAGE_SUBJECT, message);
        log.info("Email notification sent");
    }
}

package com.design.patterns.project.events;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class EmployeeCreatedConsoleNotificationSubscriber {

    private static final Logger log = LoggerFactory.getLogger(EmployeeCreatedConsoleNotificationSubscriber.class);

    @EventListener
    public void handleEmployeeCreatedEvent(final EmployeeCreatedEvent args){
        log.info(String.format("Dear %s:\n You have been registered into our internal platform for vacuum doses tracking.\n" +
                "Now you can manage your profile\n Have a Good day :)", args.getEmployeeFullName()));
    }
}

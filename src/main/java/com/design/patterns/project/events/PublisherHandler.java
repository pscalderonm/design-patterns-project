package com.design.patterns.project.events;

import com.design.patterns.project.service.EmailNotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("singleton")
public class PublisherHandler {

    @Autowired
    private EmailNotificationService emailNotificationService;
    private Publisher publisher = null;

    private synchronized void createPublisher(){
        if(publisher == null){
            publisher = new DefaultPublisher();
            publisher.addSubscriber(new EmployeeCreatedForEmailNotifySubscriber(emailNotificationService));
            publisher.addSubscriber(new EmployeeCreatedForLogSubscriber());
        }
    }

    public Publisher getPublisher(){
        if(publisher == null){
            createPublisher();
        }
        return publisher;
    }
}

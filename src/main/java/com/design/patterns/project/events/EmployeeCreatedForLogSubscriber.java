package com.design.patterns.project.events;

import com.design.patterns.project.models.Employee;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

import java.util.Objects;

public class EmployeeCreatedForLogSubscriber implements Subscriber {
    private static final Logger log = LoggerFactory.getLogger(EmployeeCreatedForLogSubscriber.class);

    @Override
    public void notify(String event, Object args) {
        Employee employee = (Employee) args;
        if(!Objects.equals(event, EventConstants.ON_EMPLOYEE_CREATED) || employee == null){
            return;
        }

        if(StringUtils.isEmpty(employee.getEmail())){
            log.info("The newly created employee has no email address defined :(");
            return;
        }

        String fullName = String.format("%s %s",
                employee.getFirstName(), employee.getLastName());

        log.info(String.format("Dear %s:\nYou have been registered into our internal platform for vacuum doses tracking.\n" +
                "Now you can manage your profile\nHave a Good day :)", fullName));
    }
}

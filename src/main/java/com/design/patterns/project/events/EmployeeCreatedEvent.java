package com.design.patterns.project.events;

import com.design.patterns.project.models.Employee;
import lombok.Data;
import lombok.Getter;
import org.springframework.context.ApplicationEvent;

public class EmployeeCreatedEvent extends ApplicationEvent {

    private final String employeeEmail;

    private final String employeeFullName;

    public EmployeeCreatedEvent(final Object source, Employee employee){
        super(source);
        employeeEmail = employee.getEmail();
        employeeFullName = employee.getFirstName()+" "+employee.getLastName();
    }

    public String getEmployeeEmail(){return employeeEmail;}

    public String getEmployeeFullName(){return employeeFullName;}
}

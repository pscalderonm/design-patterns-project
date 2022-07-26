package com.design.patterns.project.events;

public interface Publisher {
    void addSubscriber(Subscriber subscriber);
    void removeSubscriber(Subscriber subscriber);
    void notifyAll(String event, Object args);
}

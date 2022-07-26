package com.design.patterns.project.events;

import java.util.ArrayList;
import java.util.List;

public class DefaultPublisher implements Publisher {

    private final List<Subscriber> subscribers;

    public DefaultPublisher(){
        subscribers = new ArrayList<>();
    }

    @Override
    public void addSubscriber(Subscriber subscriber) {
        subscribers.add(subscriber);
    }

    @Override
    public void removeSubscriber(Subscriber subscriber) {
        subscribers.remove(subscriber);
    }

    @Override
    public void notifyAll(String event, Object args) {
        for (Subscriber subscriber: subscribers){
            subscriber.notify(event, args);
        }
    }
}

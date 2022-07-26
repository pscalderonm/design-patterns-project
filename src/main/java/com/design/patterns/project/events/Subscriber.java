package com.design.patterns.project.events;

public interface Subscriber {
    void notify(String event, Object args);
}

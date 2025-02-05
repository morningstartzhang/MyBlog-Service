package com.lovesh.progress.event;

import org.springframework.context.ApplicationEvent;


public class ProgressEndEvent extends ApplicationEvent {


    public ProgressEndEvent(Object source) {
        super(source);
    }

    public String getName() {
        return this.getSource().toString();
    }

    public static  ProgressEndEvent create(String name) {
        return new ProgressEndEvent(name);
    }

}

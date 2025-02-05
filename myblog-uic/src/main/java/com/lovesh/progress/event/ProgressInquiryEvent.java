package com.lovesh.progress.event;

import org.springframework.context.ApplicationEvent;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

public class ProgressInquiryEvent extends ApplicationEvent {

    private SseEmitter emitter;

    public SseEmitter getEmitter() {
        return emitter;
    }

    public void setEmitter(SseEmitter emitter) {
        this.emitter = emitter;
    }

    public String getName() {
        return this.getSource().toString();
    }

    public ProgressInquiryEvent(Object source) {
        super(source);
    }

    public static  ProgressInquiryEvent create(String name) {
        return new ProgressInquiryEvent(name);
    }
}

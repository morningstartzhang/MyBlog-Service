package com.lovesh.progress;

import com.lovesh.progress.event.ProgressEndEvent;
import com.lovesh.progress.event.ProgressInquiryEvent;
import com.lovesh.progress.event.ProgressStartEvent;
import com.lovesh.progress.event.ProgressStepEvent;
import com.lovesh.progress.server.IProgressDataService;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import java.math.BigDecimal;

public class ProgressContext {
    private ProgressContext() {
    }

    private static IProgressDataService srv() {
        return (IProgressDataService)ApplicationContextHolder.getBean(IProgressDataService.class);
    }

    public static boolean exists(String name) {
        return srv().inquiry(name) != null;
    }

    public static SseEmitter inquiry(String name) {
        ProgressInquiryEvent e = ProgressInquiryEvent.create(name);
        ApplicationContextHolder.publish(e);
        return e.getEmitter();
    }

    public static void start(String name, BigDecimal total) {
        ProgressStartEvent e = ProgressStartEvent.create(name).total(total);
        ApplicationContextHolder.publish(e);
    }

    public static void end(String name) {
        ProgressEndEvent e = ProgressEndEvent.create(name);
        ApplicationContextHolder.publish(e);
    }

    public static void increase(String name) {
        increase(name, BigDecimal.ONE, (BigDecimal)null);
    }

    public static void increase(String name, BigDecimal total) {
        increase(name, BigDecimal.ONE, total);
    }

    public static void increase(String name, BigDecimal step, BigDecimal total) {
        ProgressStepEvent e = ProgressStepEvent.create(name).step(step).total(total);
        ApplicationContextHolder.publish(e);
    }
}

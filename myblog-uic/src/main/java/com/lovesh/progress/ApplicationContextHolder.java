package com.lovesh.progress;

import io.micrometer.common.util.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.annotation.Lazy;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

@Component
@Lazy(false)
public class ApplicationContextHolder implements ApplicationContextAware {
    private final Logger log = LoggerFactory.getLogger(this.getClass());
    private static ApplicationContext applicationContext;

    public ApplicationContextHolder() {
    }

    private static void init(ApplicationContext context) {
        if (applicationContext == null) {
            applicationContext = context;
        }

    }

    public void setApplicationContext(ApplicationContext context) throws BeansException {
        this.log.info("Application context initialized");
        init(context);
    }

    public static <T> T getBean(Class<T> clazz) {
        return applicationContext.getBean(clazz);
    }

    public static <T> T getBean(String name) {
        return (T) applicationContext.getBean(name);
    }

    public static <T> T getBean(String name, Class<T> clazz) {
        return applicationContext.getBean(name, clazz);
    }

    public static String getApplicationParameter(String name) {
        return applicationContext.getEnvironment().getProperty(name);
    }

    public static <T extends ApplicationEvent> void publish(T event) {
        applicationContext.publishEvent(event);
    }

    public static Resource getResource(String source) {
        return StringUtils.isBlank(source) ? null : applicationContext.getResource(source);
    }
}

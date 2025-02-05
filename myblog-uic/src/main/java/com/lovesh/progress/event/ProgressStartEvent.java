package com.lovesh.progress.event;

import org.springframework.context.ApplicationEvent;

import java.math.BigDecimal;

public class ProgressStartEvent extends ApplicationEvent {

    private BigDecimal total;

    public ProgressStartEvent(Object source) {
        super(source);
    }

    public BigDecimal getTotal() {
        return this.total;
    }

    public String getName() {
        return this.getSource().toString();
    }

    public static  ProgressStartEvent create(String name) {
        return new ProgressStartEvent(name);
    }

    public ProgressStartEvent total(BigDecimal total) {
        this.total = total;
        return this;
    }


}

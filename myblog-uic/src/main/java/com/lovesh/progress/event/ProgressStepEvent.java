package com.lovesh.progress.event;

import org.springframework.context.ApplicationEvent;

import java.math.BigDecimal;

public class ProgressStepEvent extends ApplicationEvent {

    private BigDecimal step;

    private BigDecimal total;

    private ProgressStepEvent(Object source) {
        super(source);
    }

    public ProgressStepEvent step(BigDecimal source) {
        this.step = source;
        return this;
    }

    public ProgressStepEvent step(Long source) {
        return this.step(BigDecimal.valueOf(source));
    }

    public ProgressStepEvent total(BigDecimal source) {
        this.total = source;
        return this;
    }

    public ProgressStepEvent total(Long source) {
        return this.total(BigDecimal.valueOf(source));
    }

    public String getName() {
        return (String)this.getSource();
    }

    public BigDecimal getStep() {
        return this.step;
    }

    public BigDecimal getTotal() {
        return this.total;
    }

    public static ProgressStepEvent create(String name) {
        return new ProgressStepEvent(name);
    }
}

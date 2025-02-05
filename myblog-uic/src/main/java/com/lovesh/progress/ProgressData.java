package com.lovesh.progress;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.NumberUtil;
import org.springframework.util.ObjectUtils;

import java.math.BigDecimal;

public class ProgressData {
    private BigDecimal current;
    private BigDecimal total;

    public ProgressData() {
        this.current = BigDecimal.ZERO;
        this.total = BigDecimal.ZERO;
    }

    public BigDecimal getCurrent() {
        return this.current;
    }

    public void setCurrent(BigDecimal current) {
        this.current = current;
    }

    public BigDecimal getTotal() {
        return this.total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public ProgressStatus getStatus() {
        return NumberUtil.equals(this.current, BigDecimal.ZERO) && NumberUtil.equals(this.total, BigDecimal.ZERO) ? ProgressStatus.NONE : ProgressStatus.PROGRESS;
    }

    public void setStatus(ProgressStatus status) {
    }

    public void increase() {
        this.increase(BigDecimal.ONE);
    }

    public void increase(BigDecimal step) {
        this.current = this.current.add(step);
    }
}

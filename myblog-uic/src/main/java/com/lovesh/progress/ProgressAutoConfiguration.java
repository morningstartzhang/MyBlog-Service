package com.lovesh.progress;

import cn.hutool.core.util.NumberUtil;
import cn.hutool.json.JSONUtil;
import com.lovesh.progress.event.ProgressEndEvent;
import com.lovesh.progress.event.ProgressStartEvent;
import com.lovesh.progress.event.ProgressStepEvent;
import com.lovesh.progress.event.ProgressInquiryEvent;
import com.lovesh.progress.server.IProgressDataService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.EventListener;
import org.springframework.util.CollectionUtils;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import java.util.Iterator;
import java.util.List;

@Configuration
public class ProgressAutoConfiguration {
    private final Logger log = LoggerFactory.getLogger(this.getClass());
    private final EmitterPool normalPool = new EmitterPool();
    private final EmitterPool errorPool = new EmitterPool();
    private final IProgressDataService srv;

    public ProgressAutoConfiguration(final IProgressDataService srv) {
        this.srv = srv;
    }

    @EventListener({ProgressStepEvent.class})
    public void onProgressStep(ProgressStepEvent source) {
        ProgressData data = this.prepare(source);
        if (data == null) {
            this.log.error("[{}] No progress indicator found, you should send ProgressStartEvent before ProgressEvent", source.getName());
        } else {
            List<SseEmitter> items = this.normalPool.getEmitters(source.getName());
            if (CollectionUtils.isEmpty(items)) {
                this.log.warn("[{}] No emitter found", source.getName());
            } else {
                this.log.info("[{}] Send => {}", source.getName(), JSONUtil.parseObj(data));
                Iterator var4 = items.iterator();

                while(var4.hasNext()) {
                    SseEmitter em = (SseEmitter)var4.next();
                    this.send(source.getName(), em, data);
                }

                this.clearError(source.getName(), items);
                if (NumberUtil.equals(data.getCurrent(), data.getTotal())) {
                    this.clear(source.getName());
                }

            }
        }
    }

    @EventListener({ProgressStartEvent.class})
    public void onProgressStart(ProgressStartEvent source) {
        ProgressData data = new ProgressData();
        data.setTotal(source.getTotal());
        this.srv.save(source.getName(), data);
    }

    @EventListener({ProgressEndEvent.class})
    public void onProgressEnd(ProgressEndEvent source) {
        this.clear(source.getName());
    }

    @EventListener({ProgressInquiryEvent.class})
    public void onInquiry(ProgressInquiryEvent source) {
        ProgressData data = this.srv.inquiry(source.getName());
        SseEmitter em = new SseEmitter(10000L);
        source.setEmitter(em);
        if (data == null) {
            this.log.info("[{}] Process is not in progress", source.getName());
            this.send(source.getName(), em, new ProgressData());
            em.complete();
        } else {
            this.normalPool.put(source.getName(), em);
        }
    }

    private void clear(String name) {
        this.srv.delete(name);
        this.normalPool.remove(name);
    }

    private void clearError(String name, List<SseEmitter> sources) {
        List<SseEmitter> errors = this.errorPool.getEmitters(name);
        if (!CollectionUtils.isEmpty(errors)) {
            sources.removeAll(errors);
            errors.clear();
        }
    }

    private ProgressData prepare(ProgressStepEvent source) {
        ProgressData data = this.srv.inquiry(source.getName());
        if (data == null) {
            return null;
        } else {
            data.increase(source.getStep());
            if (source.getTotal() != null) {
                data.setTotal(source.getTotal());
            }

            this.srv.save(source.getName(), data);
            return data;
        }
    }

    private void send(String name, SseEmitter em, ProgressData data) {
        if (!EmitterUtil.send(em, name, data)) {
            this.errorPool.put(name, em);
        }
    }
}

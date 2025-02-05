package com.lovesh.progress;

import org.springframework.util.CollectionUtils;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class EmitterPool {
    protected final ConcurrentMap<String, List<SseEmitter>> pool = new ConcurrentHashMap<>();

    EmitterPool() {
    }

    public List<SseEmitter> getEmitters(String name) {
        return this.pool.get(name);
    }

    public synchronized List<SseEmitter> put(String name, SseEmitter source) {
        List<SseEmitter> items = this.pool.computeIfAbsent(name, k -> new ArrayList<>());
        items.add(source);
        return items;
    }

    public int size() {
        return this.pool.size();
    }

    public synchronized void remove(String name) {
        List<SseEmitter> items = this.pool.remove(name);
        if (!CollectionUtils.isEmpty(items)) {
            for (SseEmitter em : items) {
                em.complete();
            }
            items.clear();
        }
    }
}

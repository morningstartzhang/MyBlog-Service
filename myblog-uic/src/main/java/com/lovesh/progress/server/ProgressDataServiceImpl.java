package com.lovesh.progress.server;

import com.lovesh.progress.ProgressData;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class ProgressDataServiceImpl implements IProgressDataService {

    private final RedisTemplate<String, Object> redisTemplate;

    public ProgressDataServiceImpl(RedisTemplate<String, Object> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    @Override
    public void delete(String name) {

    }

    @Override
    public ProgressData inquiry(String name) {
        return (ProgressData)redisTemplate.opsForValue().get(name);
    }

    @Override
    public ProgressData save(String name, ProgressData data) {
        redisTemplate.opsForValue().set(name, data);
        return data;
    }
}

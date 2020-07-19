package com.edureka.ms.training.sessionserver.service;

import lombok.SneakyThrows;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class SlowService {

    @Cacheable("cacheKey")
    @SneakyThrows
    public String slowMethod(String key) {
        Thread.sleep(5* 1000);
        return UUID.randomUUID().toString();
    }
}

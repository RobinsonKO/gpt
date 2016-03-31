package com.gpengtao.service;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Random;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * Created by gpengtao on 15/4/19.
 */
@Component
public class CacheService {

    private Logger logger = LoggerFactory.getLogger(CacheService.class);

    private LoadingCache<String, Integer> cache = CacheBuilder.newBuilder()
            .maximumSize(3000)
            .expireAfterWrite(3, TimeUnit.SECONDS)
            .build(new CacheLoader<String, Integer>() {
                @Override
                public Integer load(String key) throws Exception {
                    return getNext();
                }
            });

    private int getNext() {
        int nextInt = new Random(System.currentTimeMillis()).nextInt();
        logger.info("get next num: {}", nextInt);
        return nextInt;
    }

    public int getValue(String key) {
        try {
            return cache.get(key);
        } catch (ExecutionException e) {
            logger.error("error", e);
            return 0;
        }
    }
}

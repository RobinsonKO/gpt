package com.gpengtao.java.guava;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;

import java.util.concurrent.TimeUnit;

/**
 * Created by pengtao.geng on 2016/10/13.
 */
public class CacheTest {

    public static void main(String[] args) throws InterruptedException {
        Cache<String, String> cache = CacheBuilder.newBuilder()
                .maximumSize(3)
                .expireAfterWrite(3, TimeUnit.SECONDS)
                .build();


        cache.put("1", "1");
        cache.put("2", "2");
        cache.put("3", "3");
        cache.put("4", "3");

        String s1 = cache.getIfPresent("2");
        System.out.println(s1);

        Thread.sleep(3000);

        String s2 = cache.getIfPresent("2");
        System.out.println(s2);

    }
}

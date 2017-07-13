package com.gpengtao.java.guava;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * Created by pengtao.geng on 2017/7/12.
 */
public class RefreshCacheTest {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        LoadingCache<String, String> cache = CacheBuilder.newBuilder()
                .maximumSize(100)
                .expireAfterWrite(10, TimeUnit.SECONDS)
                .refreshAfterWrite(2, TimeUnit.SECONDS)
                .build(new CacheLoader<String, String>() {
                    @Override
                    public String load(String key) throws Exception {
                        System.out.println("load key " + key);
                        return "2";
                    }
                });

        cache.put("a", "a");
        cache.put("b", "b");
        cache.put("c", "c");

        System.out.println(cache.get("a"));

        Thread.sleep(4000);

        System.out.println(cache.get("a"));
    }
}

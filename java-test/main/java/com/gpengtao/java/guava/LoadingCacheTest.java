package com.gpengtao.java.guava;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * Created by pengtao.geng on 2016/10/12.
 */
public class LoadingCacheTest {

    public static void main(String[] args) {
        LoadingCache<String, String> cache = CacheBuilder
                .newBuilder()
                .expireAfterWrite(24, TimeUnit.HOURS)
                .maximumSize(5000)
                .build(new CacheLoader<String, String>() {
                    @Override
                    public String load(String key) throws Exception {
//                        return null;
                        throw new RuntimeException("xxx");
                    }
                });

        String result = null;
        try {
            result = cache.get("hello");
        } catch (ExecutionException e) {
            System.out.println("ExecutionException error" + e);
            e.printStackTrace();
        } catch (Throwable t) {
            System.out.println("Throwable error:" + t);
            t.printStackTrace();
        }

        System.out.println(result);
    }
}

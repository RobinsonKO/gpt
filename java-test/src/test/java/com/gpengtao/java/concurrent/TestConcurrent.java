package com.gpengtao.java.concurrent;

import org.junit.Test;

import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by pengtao.geng on 2017/4/11.
 */
public class TestConcurrent {

    @Test
    public void test_concurrent_hash_map_put_if_absent() {
        ConcurrentHashMap<String, String> map = new ConcurrentHashMap<>();

        map.put("a", "hello");

        String v = map.putIfAbsent("a", "xx");
        String v2 = map.putIfAbsent("aa", "xx");

        System.out.println(v);
        System.out.println(v2);

        System.out.println(map);
    }

}

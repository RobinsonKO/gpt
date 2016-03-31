package com.gpengtao.test.java;
import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;
//import com.google.common.collect.TreeRangeMap;
import com.google.common.util.concurrent.AtomicLongMap;
import org.junit.Test;

import java.io.UnsupportedEncodingException;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by pengtao.geng on 2015/12/1.
 */
public class TestMap {

    @Test
    public void test_simple_map() {
        ConcurrentHashMap<String, String> map = new ConcurrentHashMap<String, String>();

        String result;

        result = map.put("hello", "1");
        System.out.println(result);

        result = map.putIfAbsent("hello", "2");
        System.out.println(result);

        System.out.println(map);

        result = map.putIfAbsent("world", "2");
        System.out.println(result);
        System.out.println(map);
    }

    @Test
    public void test_guava_atomicLongMap() {
        AtomicLongMap<String> map = AtomicLongMap.create();

        long result = map.addAndGet("hello", 10);
        System.out.println(result);

        result = map.incrementAndGet("hello");
        System.out.println(result);

        result = map.getAndIncrement("hello");
        System.out.println(result);
    }

//    @Test
//    public void test_guava_rangeMap() {
//        TreeRangeMap.create();
//    }

    @Test
    public void test_guava_multiMap() {
        Multimap<String, String> map = ArrayListMultimap.create();

        map.put("hello", "1");
        map.put("hello", "1");
        map.put("hello", "2");
        map.put("hello", "3");

        System.out.println(map);

        Collection<String> hello = map.get("hello");

        System.out.println(hello);
    }

    @Test
    public void test_lined_hash_map() {
        Map<String, String> map = new LinkedHashMap<String, String>(10, 0.75f, true);
        map.put("1", "1");
        map.put("2", "2");
        map.put("3", "3");
        map.put("4", "4");

        System.out.println(map);

        map.get("1");

        System.out.println(map);
    }

    @Test
    public void test() throws UnsupportedEncodingException {
        char x = '中';
        System.out.println((int) x);

        String string = "中";
        byte[] bytes = string.getBytes("utf-8");
        System.out.println(bytes.length);

    }
}

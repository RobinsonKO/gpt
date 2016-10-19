package com.gpengtao.java.collection;

import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by pengtao.geng on 2016/8/18.
 */
public class MapTest {

    public static void main(String[] args) {
        ConcurrentHashMap<String, String> map = new ConcurrentHashMap<>();

        System.out.println(map);

        map.put("hello", "world");

        System.out.println(map);

        System.out.println(map.size());
    }
}

package com.gpengtao.java.stream;

import com.google.common.collect.Lists;

import java.util.List;

/**
 * Created by pengtao.geng on 2016/12/7.
 */
public class Java8StreamTest {

    public static void main(String[] args) {

        List<String> list = Lists.newArrayList("a", "b", "c", "d");

        // 串行的stream
        list.stream().filter(s -> {
            System.out.println("filter " + s);
            return s.length() >= 1;
        }).forEach(System.out::println);

        System.out.println("===================");

        // 并行的stream
        list.parallelStream().filter(s -> {
            System.out.println("filter " + s);
            return s.length() >= 1;
        }).forEach(System.out::println);
    }
}

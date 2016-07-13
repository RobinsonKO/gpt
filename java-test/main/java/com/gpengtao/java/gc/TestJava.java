package com.gpengtao.java.gc;

import java.lang.management.ManagementFactory;

/**
 * Created by gpengtao on 16/7/13.
 */
public class TestJava {

    private static final int _1M_SIZE = 1024 * 1024;

    public static void main(String[] args) throws InterruptedException {

        System.out.println("pid " + ManagementFactory.getRuntimeMXBean().getName());

        byte[] allocation4 = new byte[4 * _1M_SIZE];

        Thread.sleep(1000000);
    }
}

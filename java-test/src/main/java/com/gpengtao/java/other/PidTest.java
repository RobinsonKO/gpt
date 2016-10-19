package com.gpengtao.java.other;

import java.lang.management.ManagementFactory;

/**
 * Created by gpengtao on 16/7/13.
 */
public class PidTest {

    public static void main(String[] args) {

        String pid = ManagementFactory.getRuntimeMXBean().getName();

        System.out.println("pid " + pid);

    }
}

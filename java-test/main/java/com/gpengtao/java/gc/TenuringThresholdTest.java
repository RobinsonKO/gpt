package com.gpengtao.java.gc;

/**
 * -XX:+UseSerialGC -XX:SurvivorRatio=8 -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails
 * -XX:MaxTenuringThreshold=1 -XX:+PrintTenuringDistribution
 * <p>
 * Created by gpengtao on 16/7/13.
 */
public class TenuringThresholdTest {

    private static final int _1M_SIZE = 1024 * 1024;

    public static void main(String[] args) {
        System.gc();

        byte[] allocation1 = new byte[_1M_SIZE];
        System.out.println("==========allocation1==========");

        byte[] allocation2 = new byte[4 * _1M_SIZE];
        System.out.println("==========allocation2==========");

        byte[] allocation3 = new byte[4 * _1M_SIZE];
        System.out.println("==========allocation3==========");

        // 释放4M
        allocation3 = null;

        byte[] allocation4 = new byte[4 * _1M_SIZE];

        System.out.println("==========finish==========");
    }
}

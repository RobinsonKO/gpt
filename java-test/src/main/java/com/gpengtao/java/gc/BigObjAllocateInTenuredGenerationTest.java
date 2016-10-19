package com.gpengtao.java.gc;

/**
 * -XX:+UseSerialGC -XX:SurvivorRatio=8 -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails
 * -XX:PretenureSizeThreshold=3M
 * <p>
 * Created by gpengtao on 16/7/12.
 */
public class BigObjAllocateInTenuredGenerationTest {

    private static final int _1M_SIZE = 1024 * 1024;

    public static void main(String[] args) {
        byte[] allocation = new byte[4 * _1M_SIZE];

        System.out.println("finish");
    }

    /**
     * 结果:
     * 大对象直接分配到tenured generation,
     * tenured generation占用了40%,即4M
     *
     Heap
     def new generation   total 9216K, used 1655K [0x00000007bec00000, 0x00000007bf600000, 0x00000007bf600000)
     eden space 8192K,  20% used [0x00000007bec00000, 0x00000007bed9de78, 0x00000007bf400000)
     from space 1024K,   0% used [0x00000007bf400000, 0x00000007bf400000, 0x00000007bf500000)
     to   space 1024K,   0% used [0x00000007bf500000, 0x00000007bf500000, 0x00000007bf600000)
     tenured generation   total 10240K, used 4096K [0x00000007bf600000, 0x00000007c0000000, 0x00000007c0000000)
     the space 10240K,  40% used [0x00000007bf600000, 0x00000007bfa00010, 0x00000007bfa00200, 0x00000007c0000000)
     Metaspace       used 3037K, capacity 4494K, committed 4864K, reserved 1056768K
     class space    used 334K, capacity 386K, committed 512K, reserved 1048576K
     *
     */
}

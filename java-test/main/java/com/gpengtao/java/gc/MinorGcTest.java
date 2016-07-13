package com.gpengtao.java.gc;

/**
 * -XX:+UseSerialGC -XX:SurvivorRatio=8 -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails
 * <p>
 * Created by gpengtao on 16/7/12.
 */
public class MinorGcTest {

    private static final int _1M_SIZE = 1024 * 1024;

    public static void main(String[] args) throws InterruptedException {
        byte[] allocation1 = new byte[2 * _1M_SIZE];
        byte[] allocation2 = new byte[2 * _1M_SIZE];
        byte[] allocation3 = new byte[2 * _1M_SIZE];
        byte[] allocation4 = new byte[4 * _1M_SIZE];

        System.out.println(allocation1);
        System.out.println(allocation2);
        System.out.println(allocation3);
        System.out.println(allocation4);

        Thread.sleep(1000);
    }

    /**
     * 结果:
     * 分配allocation4时候eden已经被占用了6M(共8M),出发一次MinorGC;
     * 已有的3个2M对象无法进入Survivor空间(只有1M大小),所以只好通过分配担保机制提前转移到老年代;
     * GC结束后,4M的allocation4空间在eden,老年代被占用6M(allocation1-3);
     *
     [GC (Allocation Failure) [DefNew: 7635K->531K(9216K), 0.0065659 secs] 7635K->6675K(19456K), 0.0065955 secs]
     [Times: user=0.00 sys=0.00, real=0.00 secs]
     *
     *
     Heap
     def new generation   total 9216K, used 4921K [0x00000007bec00000, 0x00000007bf600000, 0x00000007bf600000)
     eden space 8192K,  53% used [0x00000007bec00000, 0x00000007bf049758, 0x00000007bf400000)
     from space 1024K,  51% used [0x00000007bf500000, 0x00000007bf584ed0, 0x00000007bf600000)
     to   space 1024K,   0% used [0x00000007bf400000, 0x00000007bf400000, 0x00000007bf500000)
     tenured generation   total 10240K, used 6144K [0x00000007bf600000, 0x00000007c0000000, 0x00000007c0000000)
     the space 10240K,  60% used [0x00000007bf600000, 0x00000007bfc00030, 0x00000007bfc00200, 0x00000007c0000000)
     Metaspace       used 3116K, capacity 4494K, committed 4864K, reserved 1056768K
     class space    used 343K, capacity 386K, committed 512K, reserved 1048576K
     *
     *
     */
}

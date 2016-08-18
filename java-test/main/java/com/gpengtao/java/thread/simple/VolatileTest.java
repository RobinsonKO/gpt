package com.gpengtao.java.thread.simple;

/**
 * Created by pengtao.geng on 2016/8/3.
 */
public class VolatileTest {

    private static volatile int race = 0;

    private static void increase() {
        race++;
    }

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 20; ++i) {
            new Thread(() -> {
                for (int i1 = 0; i1 < 10000; ++i1) {
                    increase();
                }
            }).start();
        }

        while (Thread.activeCount() > 2) {
            System.out.println("now: " + race + " ,Thread.activeCount() :" + Thread.activeCount());

            Thread.sleep(1000);
        }

        System.out.println("result: " + race);
    }
}

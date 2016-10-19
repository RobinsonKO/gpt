package com.gpengtao.java.thread;

/**
 * Created by gpengtao on 14-10-15.
 */
public class TestCount {
    public static void main(String[] args) throws InterruptedException {
        ThreadNotSafeCount notSafeCount = new ThreadNotSafeCount();
        for (int i = 0; i < 10; ++i) {
            new Thread(notSafeCount).start();
        }
        Thread.sleep(1000);
        System.out.println(notSafeCount.getCount());

        ThreadNotSafeCount safeCount = new ThreadNotSafeCount();
        for (int i = 0; i < 10; ++i) {
            new Thread(safeCount).start();
        }
        Thread.sleep(1000);
        System.out.println(safeCount.getCount());
    }
}

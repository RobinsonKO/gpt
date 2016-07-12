package com.gpengtao.java.thread;

import java.util.concurrent.CountDownLatch;

/**
 * Created by pengtao.geng on 14-9-30.
 */
public class LatchesTest {
    public static void main(String[] args) {
        CountDownLatch latch = new CountDownLatch(2);

        loadingUserOne(latch);
        loadingUserTwo(latch);

        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("all user ready");

    }

    private static void loadingUserTwo(final CountDownLatch latch) {
        new Thread() {
            public void run() {
                try {
                    sleep(200);
                    System.out.println("user 2 ready");
                    latch.countDown();

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }.start();
    }

    private static void loadingUserOne(final CountDownLatch latch) {
        new Thread() {
            public void run() {
                try {
                    sleep(280);
                    System.out.println("user 1 ready");
                    latch.countDown();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }.start();
    }
}

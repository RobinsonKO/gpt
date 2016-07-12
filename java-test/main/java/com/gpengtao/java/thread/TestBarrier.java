package com.gpengtao.java.thread;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * Created by pengtao.geng on 14-10-16.
 */
public class TestBarrier {
    public static void main(String[] args) {
        final CyclicBarrier barrier = new CyclicBarrier(4, new Runnable() {
            @Override
            public void run() {
                System.out.println("4 part cross barrier");
            }
        });


        for (int i = 0; i < 5; ++i) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(new Random().nextInt(1000));

                        System.out.println(Thread.currentThread().getName() + " come to barrier");

                        barrier.await();

                        System.out.println(Thread.currentThread().getName() + " cross barrier");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } catch (BrokenBarrierException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }

    }
}

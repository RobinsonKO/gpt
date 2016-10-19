package com.gpengtao.java.thread;

import java.lang.management.ManagementFactory;

/**
 * Created by gpengtao on 14-10-15.
 */
public class TestDaemon {
    public static void main(String[] args) {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("say hello");
                try {
                    System.out.println("pid " + ManagementFactory.getRuntimeMXBean().getName());
                    Thread.sleep(100 * 1000);

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

//        thread.setDaemon(true);
        thread.start();

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}



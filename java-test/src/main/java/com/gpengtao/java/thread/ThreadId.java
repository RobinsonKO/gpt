package com.gpengtao.java.thread;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by gpengtao on 15-1-14.
 */
public class ThreadId {

    private static final AtomicInteger nextId = new AtomicInteger(111);

    private static final ThreadLocal<Integer> threadId =
            new ThreadLocal<Integer>() {
                @Override
                protected Integer initialValue() {
                    return nextId.getAndIncrement();
                }
            };

    public static int get() {
        return threadId.get();
    }

    private static final ThreadLocal<String> s = new ThreadLocal<String>();

    public static void main(String[] args) {
        System.out.println(Thread.currentThread() + " 获得id： " + ThreadId.get());
        Thread thread = new Thread() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread() + " 获得id:" + ThreadId.get());

            }
        };

        thread.start();
    }
}

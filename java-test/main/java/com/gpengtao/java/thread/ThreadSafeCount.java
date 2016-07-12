package com.gpengtao.java.thread;

/**
 * Created by gpengtao on 14-10-15.
 */
public class ThreadSafeCount implements Runnable {
    private int count = 0;

    @Override
    public void run() {
        for (int i = 0; i < 10; ++i) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            increase();
        }
    }

    synchronized public void increase() {
        count++;
    }

    public int getCount() {
        return count;
    }
}

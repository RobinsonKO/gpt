package com.gpengtao.java.thread;


public class ThreadNotSafeCount implements Runnable {

    private int count = 0;

    @Override
    public void run() {
        for (int i = 0; i < 10; ++i) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            count++;
        }
    }

    public int getCount() {
        return count;
    }
}

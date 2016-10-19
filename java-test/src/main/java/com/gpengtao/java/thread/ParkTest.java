package com.gpengtao.java.thread;

import java.util.concurrent.locks.LockSupport;

/**
 * Created by pengtao.geng on 2016/4/19.
 */
public class ParkTest {

    public static void main(String[] args) {
        UnParkThread unParkThread = new UnParkThread(Thread.currentThread());
        unParkThread.start();

        LockSupport.park();
        System.out.println("main thread finish");
    }

    static class UnParkThread extends Thread {

        private Thread unpark;

        public UnParkThread(Thread unpark) {
            this.unpark = unpark;
        }

        @Override
        public void run() {
            System.out.println("un park thread run ...");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            LockSupport.unpark(unpark);
            System.out.println("un park thread run finish");

        }
    }
}

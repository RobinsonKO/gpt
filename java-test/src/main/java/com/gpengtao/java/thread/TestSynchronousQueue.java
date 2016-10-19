package com.gpengtao.java.thread;

import java.lang.management.ManagementFactory;
import java.util.concurrent.SynchronousQueue;

/**
 * Created by pengtao.geng on 14-10-16.
 */
public class TestSynchronousQueue {
    public static void main(String[] args) {

        System.out.println("pid: " + ManagementFactory.getRuntimeMXBean().getName());

        final SynchronousQueue synQueue = new SynchronousQueue();
        System.out.println("sysQueue size:" + synQueue.size());// size 0
        System.out.println("sysQueue capacity:" + synQueue.remainingCapacity());// capacity 0

        Thread myThread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    synQueue.put("");// block thread
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "myThread");
        myThread.start();

        try {
            synQueue.put("");// block thread
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

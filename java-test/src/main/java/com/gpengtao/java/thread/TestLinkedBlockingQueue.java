package com.gpengtao.java.thread;

import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created by pengtao.geng on 14-10-16.
 */
public class TestLinkedBlockingQueue {
    public static void main(String[] args) {
        LinkedBlockingQueue<String> queue = new LinkedBlockingQueue<String>(2);

        System.out.println("size: " + queue.size());
        System.out.println("capacity:" + queue.remainingCapacity());

//        queue.poll();

//        try {
//            queue.take();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

        try {
            queue.put("1");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("size: " + queue.size());

        try {
            queue.put("2");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("size: " + queue.size());


        try {
            queue.put("3");// block
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("size: " + queue.size());
    }
}

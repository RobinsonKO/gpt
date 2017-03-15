package com.gpengtao.java.interview;

import java.util.concurrent.SynchronousQueue;

/**
 * Created by pengtao.geng on 2017/3/15.
 */
public class PrintNumTest {

    public static void main(String[] args) throws InterruptedException {

        SynchronousQueue<Integer> queueA = new SynchronousQueue<>();
        SynchronousQueue<Integer> queueB = new SynchronousQueue<>();

        new Thread("thread_A") {
            @Override
            public void run() {
                try {
                    System.out.println(getName() + " start running ...");
                    while (true) {
                        System.out.println(getName() + " take ...");
                        Integer num = queueA.take();
                        if (num + 1 <= 10) {
                            System.out.println(getName() + " >>>> " + num);
                            queueB.put(num + 1);
                        } else {
                            break;
                        }
                    }
                    System.out.println(getName() + " finish");
                } catch (Throwable e) {
                    e.printStackTrace();
                }
            }
        }.start();

        new Thread("thread_B") {
            @Override
            public void run() {
                try {
                    System.out.println(getName() + " start running ...");
                    while (true) {
                        System.out.println(getName() + " take ...");
                        Integer num = queueB.take();
                        if (num <= 10) {

                            System.out.println(getName() + " <<<< " + num);

                            queueA.put(num + 1);
                        } else {
                            break;
                        }
                    }
                    System.out.println(getName() + " finish");
                } catch (Throwable e) {
                    e.printStackTrace();
                }
            }
        }.start();

        queueA.put(1);

        System.out.println("main offer 1");

        Thread.sleep(1000);

        System.out.println("main finish");
    }
}

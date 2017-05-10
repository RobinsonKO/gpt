package com.gpengtao.java.interview;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * 两个交替打印数字
 * <p>
 * Created by pengtao.geng on 2017/3/15.
 */
public class AlternatelyPrintNumTest {

    public static void main(String[] args) throws InterruptedException {

        BlockingQueue<Integer> queueA = new LinkedBlockingDeque<>();
        BlockingQueue<Integer> queueB = new LinkedBlockingDeque<>();

        new Thread("thread_A") {
            @Override
            public void run() {
                try {
                    System.out.println(getName() + " start running ...");
                    while (true) {
                        Integer num = queueA.take();

                        System.out.println(getName() + " >>>> " + num);
                        queueB.put(num + 1);
                        if (num + 1 >= 10) {
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
                        Integer num = queueB.take();

                        System.out.println(getName() + " <<<< " + num);
                        queueA.put(num + 1);

                        if (num + 1 >= 10) {
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

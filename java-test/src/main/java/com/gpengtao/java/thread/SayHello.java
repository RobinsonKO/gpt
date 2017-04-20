package com.gpengtao.java.thread;

/**
 * Created by gpengtao on 14-10-15.
 */
public class SayHello implements Runnable {
    private int i;

    SayHello(int i) {
        this.i = i;
    }

    @Override
    public void run() {// 实现run方法
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " say hello" + i);
    }

    public static void main(String[] args) {
        Thread thread = new Thread(new SayHello(1));// 线程就是一个对线，可以运行“可以Run的东西”
        thread.start();
    }
}

package com.gpengtao.java.thread;

/**
 * Created by gpengtao on 14-10-14.
 */
public class TestInterrupt {

    public static void main(String[] args) {
        Thread thread = new Thread(new Runnable() {
            public void run() {
                while (true) {
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {// 仅仅是sleep被中断了，此时线程中断状态还是false
                        System.out.println("sleep 被中断，线程中断状态现在是 " + Thread.currentThread().isInterrupted());
                    }
                    System.out.println("当前线程中断状态" + Thread.currentThread().isInterrupted());
                    if (Thread.currentThread().isInterrupted()) {
                        System.out.println("监测到中断，中断线程");
                        break;
                    }
                }
            }
        });
        thread.start();

        while (true) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("发出中断信号");
            thread.interrupt();// 不停的发送中断
            if (thread.getState() == Thread.State.TERMINATED) {// 监测线程是否已经结束了
                System.out.println("线程已经terminated,程序结束");
                break;
            }
        }
    }
}

package com.gpengtao.java.thread;

/**
 * Created by gpengtao on 14-10-14.
 */
public class ReadResultThread extends Thread {

    private CalcThread c;

    public ReadResultThread(CalcThread calculator) {
        c = calculator;
    }

    @Override
    public void run() {
        synchronized (c) {
            try {
                System.out.println(Thread.currentThread() + "wait result");
                c.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread() + "result:" + c.getTotal());
        }
    }

    public static void main(String[] args) {
        CalcThread calculator = new CalcThread();

        //启动三个线程，分别获取计算结果
        new ReadResultThread(calculator).start();
        new ReadResultThread(calculator).start();
        new ReadResultThread(calculator).start();
        //启动计算线程
        calculator.start();
    }
}

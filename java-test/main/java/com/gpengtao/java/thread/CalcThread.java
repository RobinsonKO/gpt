package com.gpengtao.java.thread;

/**
 * Created by gpengtao on 14-10-14.
 */
public class CalcThread extends Thread {
    private int total;

    @Override
    public void run() {
        synchronized (this) {
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("calc finish ,notify");
            setTotal(0);
            this.notifyAll();
        }
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
}

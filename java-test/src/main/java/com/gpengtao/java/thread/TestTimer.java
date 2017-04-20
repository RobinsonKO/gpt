package com.gpengtao.java.thread;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by gpengtao on 14-10-14.
 */
public class TestTimer {
    public static void main(String[] args) {
        Timer timer = new Timer();
        timer.schedule(new TimerTaskOne(), 0, 2000);
        timer.schedule(new TimerTaskTow(), 0, 1000);
    }
}

class TimerTaskOne extends TimerTask {
    @Override
    public void run() {
        System.out.println("do task one");
        throw new RuntimeException("error");
    }
}

class TimerTaskTow extends TimerTask {
    @Override
    public void run() {
        System.out.println("do task two");
    }
}

package com.gpengtao.java.thread;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Created by gpengtao on 14-10-14.
 */
public class TestScheduledExecutor {
    public static void main(String[] args) {
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
        executor.scheduleAtFixedRate(new TimerTaskOne(), 0, 2000, TimeUnit.MILLISECONDS);
        executor.scheduleAtFixedRate(new TimerTaskTow(), 0, 1000, TimeUnit.MILLISECONDS);
    }
}

package com.gpengtao.java.thread;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created by gpengtao on 14-10-15.
 */
public class TestThreadPoolExecutor {
    public static void main(String[] args) {

        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1, 1, 1, TimeUnit.SECONDS, new LinkedBlockingDeque<Runnable>());

        threadPoolExecutor.submit(new SayHello(2));
    }
}
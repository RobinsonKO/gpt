package com.gpengtao.java.thread;

import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created by pengtao.geng on 14-10-16.
 */
public class TestThreadPollExecutor {

    public static void main(String[] args) {
        ThreadPoolExecutor threadPool = new ThreadPoolExecutor(0, 2, 1, TimeUnit.MINUTES, new SynchronousQueue<Runnable>());

        for (int i = 0; i < 10; ++i) {
            threadPool.submit(new SayHello(i));
        }

//        ExecutorService executorService = Executors.newCachedThreadPool();
//
//        for (int i = 0; i < 10; ++i) {
//            executorService.submit(new SayHello(i));
//        }

    }
}

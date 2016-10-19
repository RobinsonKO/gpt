package com.gpengtao.java.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

/**
 * Created by gpengtao on 14-10-14.
 */
public class TestExecutors {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(2);

        for (int i = 0; i < 10; ++i) {
            fixedThreadPool.execute(new SayHello(i));
//            if(i == 5){
//                fixedThreadPool.shutdown();
//            }
        }
        fixedThreadPool.shutdown();

        /////////////////////////////////////////

        ExecutorService singleThreadExecutor = Executors.newSingleThreadExecutor(new ThreadFactory() {
            @Override
            public Thread newThread(Runnable r) {
                return new Thread(r, "HelloWorldThread");
            }
        });
        for (int i = 0; i < 3; ++i) {
            singleThreadExecutor.execute(new SayHello(i));
        }

    }
}

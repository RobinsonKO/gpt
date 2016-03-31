package org.gpengtao.thread;

import java.lang.management.ManagementFactory;
import java.util.concurrent.*;

/**
 * Created by gpengtao on 14-10-14.
 */
public class TestFuture {
    public static void main(String[] args) {
        String pid = ManagementFactory.getRuntimeMXBean().getName();
        System.out.println(pid);
        ExecutorService executor = Executors.newSingleThreadExecutor();

        Future<?> future1 = executor.submit(new Runnable() {
            @Override
            public void run() {
                System.out.println("say hello");
            }
        });

        try {
            Object o = future1.get();// 返回null
            System.out.println(o);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        ///////////////////////////////////////////////

        Future<String> future2 = executor.submit(new Callable<String>() {
            @Override
            public String call() throws Exception {
                return "hello";
            }
        });
        try {
            String result = future2.get();// 返回线程执行结果 "hello"
            System.out.println(result);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        //////////////////////////////////////////////
        Future<String> future3 = executor.submit(new Runnable() {
            @Override
            public void run() {
                System.out.println("ready to say");
            }
        }, "hello");
        try {
            String s = future3.get();
            System.out.println(s);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}

package com.gpengtao.java.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

class PreLoader {
    private FutureTask<String> futureTask = new FutureTask(new Callable<String>() {
        @Override
        public String call() throws Exception {
            Thread.sleep(1000);
            return "hello";
        }
    });

    private Thread thread = new Thread(futureTask);

    public void start() {
        thread.start();
    }

    public String getResult() {
        try {
            return futureTask.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        return null;
    }
}

public class TestFutureTask {

    public static void main(String[] args) {
        PreLoader loader = new PreLoader();
        loader.start();

        System.out.println("get result");
        String result = loader.getResult();
        System.out.println(result);
    }
}

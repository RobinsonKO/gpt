package org.gpengtao.thread;

import java.util.concurrent.*;

/**
 * Created by gpengtao on 14-10-14.
 */
public class TestExecutorCompletionService {
    public static void main(String[] args) {

        ExecutorService threadPool = Executors.newFixedThreadPool(2);

        CompletionService<String> service = new ExecutorCompletionService<String>(threadPool);

        service.submit(new Callable<String>() {
            @Override
            public String call() throws Exception {
                Thread.sleep(1000);
                System.out.println("process finish");
                return Thread.currentThread().getName() + " say hello";
            }
        });


        try {
            for (int i = 0; i < 2; ++i) {
                System.out.println("ready to get future...");
                Future<String> future = service.take();// 等到一个执行完成的线程才返回
                System.out.println("get future");
                String result = future.get();// 获得结果
                System.out.println("future one " + result);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}

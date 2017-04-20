package com.gpengtao;

import java.util.Queue;

/**
 * Created by gpengtao on 16/11/18.
 */
public class MyFactory {

    private Queue<Thread> working;

    private Queue<Thread> idle;

    public Thread getOne() {
        if (idle.size() == 0) {
            createOne();
        }
        Thread thread = idle.peek();

        working.add(thread);

        return thread;
    }

    private void createOne() {

    }
}

package com.gpengtao.test.other;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Created by pengtao.geng on 2015/7/16.
 */
public class TestThread {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Test
    public void test_scheduled_execute_service() throws IOException {
        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(2);

        executorService.scheduleAtFixedRate(new CanRun(1), 1, 1, TimeUnit.SECONDS);
        logger.info("execute 1 .....");

        executorService.scheduleAtFixedRate(new CanRun(2), 1, 1, TimeUnit.SECONDS);
        logger.info("execute 2 .....");

        executorService.scheduleAtFixedRate(new CanRun(3), 1, 1, TimeUnit.SECONDS);
        logger.info("execute 3 .....");

        executorService.scheduleAtFixedRate(new CanRun(4), 1, 1, TimeUnit.SECONDS);
        logger.info("execute 4 .....");

        logger.info("all execute");
        System.in.read();
    }

    class CanRun implements Runnable {
        private int id;

        public CanRun(int id) {
            this.id = id;
        }

        @Override
        public void run() {
            logger.info("invoke id {} ...", id);
            for (int i = 0; i < 3; ++i) {
                logger.info("id {} is running ...", id);
                if (i == 2) {
                    throw new RuntimeException();
                }
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    logger.error("error", e);
                }
            }
        }
    }

}


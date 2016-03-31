package com.gpengtao.test.zk;

import org.apache.zookeeper.*;
import org.apache.zookeeper.data.Stat;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.print.DocFlavor;
import java.io.IOException;
import java.util.List;

/**
 * Created by gpengtao on 15/9/27.
 */
public class TestZK {

    private static Logger logger = LoggerFactory.getLogger("TestZk");

    private ZooKeeper zooKeeper;

    @Before
    public void create_zookeeper_con() throws IOException {
        zooKeeper = new ZooKeeper("10.86.36.12:2181,10.86.36.15:2181", 1000, new Watcher() {

            public void process(WatchedEvent event) {
                logger.info("收到WatchedEvent是：{}", event);
            }
        });

        logger.info("建立的zk是:{}", zooKeeper);
    }

    @Test
    public void test_zookeeper() throws IOException, KeeperException, InterruptedException {

        Stat stat = zooKeeper.exists("/test3", true);
        logger.info("test3的stat是：{}", stat);

        zooKeeper.exists("/test3", new Watcher() {

            public void process(WatchedEvent event) {
                logger.info("=====test3=====event:{}", event);
            }
        });


        System.in.read();

        zooKeeper.close();
    }

    @Test
    public void test_create_node() throws IOException, KeeperException, InterruptedException {

        zooKeeper.create("/test4", "hello4".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL);

        System.in.read();
    }

    @Test
    public void test_zk() throws KeeperException, InterruptedException {
        List<String> children = zooKeeper.getChildren("/", false);
        for (String one : children) {
            System.out.println(one);
        }

        byte[] data = zooKeeper.getData("/test", false, null);
        System.out.println(new String(data));
    }
}

package com.gpengtao.java.gc;

import java.lang.management.GarbageCollectorMXBean;
import java.lang.management.ManagementFactory;
import java.lang.management.ThreadMXBean;
import java.util.List;

/**
 * Created by pengtao.geng on 2016/10/8.
 */
public class GCNameTest {

    public static void main(String[] args) {
        ThreadMXBean threadBean = ManagementFactory.getThreadMXBean();

        System.out.println(threadBean.getThreadCount());

        List<GarbageCollectorMXBean> beans = ManagementFactory.getGarbageCollectorMXBeans();

        for (GarbageCollectorMXBean bean : beans) {
            System.out.println(bean.getName());
        }
    }
}

package com.gpengtao.test.mbean;

import javax.management.MBeanServer;
import javax.management.ObjectName;
import java.lang.management.ManagementFactory;

/**
 * Created by pengtao.geng on 2016/4/21.
 */
public class MainServer {
    public static void main(String[] args) {
        try {
            MBeanServer mBeanServer = ManagementFactory.getPlatformMBeanServer();

            // 路径随便写:name=名字随便写（(name也可以是type关键字)）
            ObjectName objectName = new ObjectName("com.gpengtao.test.mbean.x.y.z:name=HelloWold");

            Hello helloObject = new Hello();

            mBeanServer.registerMBean(helloObject, objectName);

            System.out.println("registry finish");

            System.in.read();

        } catch (Throwable t) {
            t.printStackTrace();
        }
    }
}

package com.gpengtao.test.mbean;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Ordering;

import javax.management.MBeanServerConnection;
import javax.management.ObjectName;
import javax.management.remote.JMXConnector;
import javax.management.remote.JMXConnectorFactory;
import javax.management.remote.JMXServiceURL;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by pengtao.geng on 2016/4/21.
 */
public class MainClient2 {

    public static void main(String[] args) {
        try {

            JMXServiceURL jmxServiceURL = new JMXServiceURL("service:jmx:rmi:///jndi/rmi://127.0.0.1:7199/jmxrmi");

            Map<String, Object> env = Maps.newHashMap();
            String[] auth = new String[]{"xx", "xx"};
            env.put(javax.management.remote.JMXConnector.CREDENTIALS, auth);

            JMXConnector jmxConnector = JMXConnectorFactory.connect(jmxServiceURL, env);

            MBeanServerConnection mBeanServerConnection = jmxConnector.getMBeanServerConnection();
            String[] domains = mBeanServerConnection.getDomains();

            // 排序，打印
            List<String> domainList = Lists.newArrayList(domains);
            Collections.sort(domainList, Ordering.natural());
            for (String domain : domainList) {
                System.out.println("domain: " + domain);
            }

            // mbean数量
            System.out.println("mbean count: " + mBeanServerConnection.getMBeanCount());

            // 获得所有mbean
            Set<ObjectName> objectNames = mBeanServerConnection.queryNames(null, null);
            System.out.println(objectNames);

            for (ObjectName objectName : objectNames) {
                System.out.println(objectName);
            }

        } catch (Throwable e) {
            e.printStackTrace();
        }
    }
}

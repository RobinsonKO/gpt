package com.gpengtao.test.mbean;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Ordering;

import javax.management.MBeanServerConnection;
import javax.management.remote.JMXConnector;
import javax.management.remote.JMXConnectorFactory;
import javax.management.remote.JMXServiceURL;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * Created by pengtao.geng on 2016/4/21.
 */
public class MainClient {

    public static void main(String[] args) {
        try {

            JMXServiceURL jmxServiceURL = new JMXServiceURL("service:jmx:rmi:///jndi/rmi://127.0.0.1:53941/jmxrmi");

            JMXConnector connect = JMXConnectorFactory.connect(jmxServiceURL, null);

            MBeanServerConnection connection = connect.getMBeanServerConnection();
            String[] domains = connection.getDomains();

            // 排序，打印
            List<String> domainList = Lists.newArrayList(domains);
            Collections.sort(domainList, Ordering.natural());
            for (String domain : domainList) {
                System.out.println("domain: " + domain);
            }

        } catch (Throwable e) {
            e.printStackTrace();
        }
    }
}

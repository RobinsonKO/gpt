package com.gpengtao.java.net;

import java.net.InetAddress;

/**
 * Created by pengtao.geng on 2016/9/26.
 */
public class MachineName {

    public static String getMachineName() {
        try {
            InetAddress localHost = InetAddress.getLocalHost();
            return localHost.getHostName();
        } catch (Throwable t) {
            t.printStackTrace();
            return "";
        }
    }

    public static void main(String[] args) {
        System.out.println(getMachineName());
    }
}

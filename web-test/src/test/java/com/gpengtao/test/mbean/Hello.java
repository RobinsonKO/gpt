package com.gpengtao.test.mbean;

/**
 * Created by pengtao.geng on 2016/4/21.
 */
public class Hello implements HelloMBean {
    private int count = 0;

    public void sayHello() {
        System.out.println("say hello");
    }

    public int getNum() {
        return count++;
    }

    public int getCount() {
        return 0;
    }

    public int getHello() {
        return 0;
    }

    public void getNoting() {

    }
}

package com.gpengtao.test.java;

/**
 * Created by gpengtao on 15/11/17.
 */
public class Test {

    public static void main(String[] args) {
        Object o1 = true ? new Integer(1) : new Double(2.0);
        Object o2 = new Integer(1);
        System.out.println(o1);
        System.out.println(o2);


    }
}

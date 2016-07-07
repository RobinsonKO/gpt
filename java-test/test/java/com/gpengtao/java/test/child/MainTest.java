package com.gpengtao.java.test.child;

/**
 * Created by pengtao.geng on 2016/4/22.
 */
public class MainTest {

    public static void main(String[] args) {
        ChildClass obj = new ChildClass();

        String name = obj.getClassName();

        System.out.println(name);
    }

    @Test
    public void test() {

    }
}

package com.gpengtao.java.clazz.init;

/**
 * 通过子类引用父类的静态字段,不会出发子类初始化
 * <p>
 * Created by gpengtao on 16/7/18.
 */
public class NotInitSubClassTest {

    /**
     * -XX:+TraceClassLoading 显示所有的来加载
     *
     * @param args
     */
    public static void main(String[] args) {
        // 只初始化了super class
        System.out.println(SubClass.value);
    }

}

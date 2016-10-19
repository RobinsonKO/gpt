package com.gpengtao.java.clazz.init;

/**
 * 通过数组定义来引用来,不会出发此类的初始化
 * <p>
 * Created by gpengtao on 16/7/18.
 */
public class NotInitSuperClass {

    public static void main(String[] args) {
        // newarray 未出发类初始化
        SuperClass[] superClasses = new SuperClass[3];
        for (SuperClass superClass : superClasses) {
            System.out.println(superClass);
        }
        System.out.println("长度:" + superClasses.length);

        // 触发类初始化
        superClasses[1] = new SuperClass();

    }
}

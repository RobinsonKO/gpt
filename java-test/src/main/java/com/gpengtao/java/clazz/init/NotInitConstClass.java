package com.gpengtao.java.clazz.init;

/**
 * static final 常量在编译阶段会存入类的常量池,
 * 本质上没有直接引用到定义常量的类,因此不会出发定义常量的类的初始化
 * <p>
 * Created by gpengtao on 16/7/18.
 */
public class NotInitConstClass {

    public static void main(String[] args) {
        System.out.println(ConstClass.HELLO);
    }
}

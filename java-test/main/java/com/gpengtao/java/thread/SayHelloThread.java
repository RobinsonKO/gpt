package com.gpengtao.java.thread;

public class SayHelloThread extends Thread {

    @Override
    public void run() {// 重新run方法
        System.out.println("say hello");
    }

    public static void main(String[] args) {
        SayHelloThread myThread = new SayHelloThread();// 线程就是一个对象而已
        myThread.start();// 让线程运行起来
    }
}

package com.gpengtao.java.thread;

import java.io.IOException;
import java.net.ServerSocket;

/**
 * Created by gpengtao on 14-10-15.
 */
public class TestCanNotInterrupt {

    public static void main(String[] args) throws InterruptedException {
        ServerThread serverThread = new ServerThread();
        serverThread.start();

        Thread.sleep(1000);

        System.out.println("线程状态" + serverThread.getState());

        System.out.println("线程中断状态" + serverThread.isInterrupted());
        serverThread.interrupt();
        System.out.println("线程中断状态" + serverThread.isInterrupted());

        serverThread.closeSocket();

    }
}

class ServerThread extends Thread {
    private ServerSocket socket;

    @Override
    public void run() {
        try {
            socket = new ServerSocket(8888);
            socket.accept();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void closeSocket() {
        if (socket == null) {
            return;
        }
        try {
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

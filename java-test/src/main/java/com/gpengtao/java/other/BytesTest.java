package com.gpengtao.java.other;

import java.util.Arrays;

/**
 * Created by pengtao.geng on 2016/11/2.
 */
public class BytesTest {

    public static void main(String[] args) {
        byte[] bytes = new byte[10];

        for (int i = 0; i < bytes.length; ++i) {
            bytes[i] = (byte) (i + 1);
        }

        for (byte aByte : bytes) {
            System.out.print(aByte + "\t");
        }
    }

}

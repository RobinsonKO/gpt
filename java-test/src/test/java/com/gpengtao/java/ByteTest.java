package com.gpengtao.java;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by pengtao.geng on 2016/11/7.
 */
public class ByteTest {

    @Test
    public void test_plus_plus() {
        byte[] array = {1, 2, 3};

        array[1]++;

        for (byte b : array) {
            System.out.println(b);
        }

        Assert.assertEquals(3, array[1]);
    }
}

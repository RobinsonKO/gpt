package com.gpengtao.java.number;

import java.math.BigDecimal;

/**
 * Created by pengtao.geng on 2017/3/22.
 */
public class TestBigDecimal {

    public static void main(String[] args) {
        System.out.println(Double.toString(1.0));
        System.out.println(Double.toString(1.00));

        BigDecimal v1 = BigDecimal.valueOf(1.0);
        BigDecimal v2 = BigDecimal.valueOf(1.00);
        System.out.println(v1.equals(v2));

    }
}

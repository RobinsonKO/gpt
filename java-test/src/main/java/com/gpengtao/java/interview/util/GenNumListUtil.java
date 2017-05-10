package com.gpengtao.java.interview.util;

import com.google.common.collect.Lists;

import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * Created by gpengtao on 2017/5/10.
 */
public class GenNumListUtil {

    public static void main(String[] args) {
        List<Integer> list = Lists.newArrayList();

        for (int i = 0; i < 5; i++) {
            Random random = new Random(System.currentTimeMillis() + i * 100);

            list.add(random.nextInt(100));
        }

        Collections.sort(list);

        System.out.println(list);
    }
}

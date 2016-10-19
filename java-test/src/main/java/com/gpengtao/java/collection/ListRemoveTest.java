package com.gpengtao.java.collection;

import com.google.common.collect.Lists;

import java.util.Iterator;
import java.util.List;

/**
 * Created by pengtao.geng on 2016/10/13.
 */
public class ListRemoveTest {

    public static void main(String[] args) {
        List<Integer> list = Lists.newArrayList();
        for (int i = 1; i <= 10; ++i) {
            list.add(i);
        }

        Iterator<Integer> iterator = list.iterator();

        while (iterator.hasNext()) {
            Integer integer = iterator.next();
            if (integer == 5) {
                iterator.remove();
            }
        }

        System.out.println(list);
    }
}

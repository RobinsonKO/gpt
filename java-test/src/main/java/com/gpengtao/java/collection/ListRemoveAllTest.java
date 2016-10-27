package com.gpengtao.java.collection;

import com.google.common.collect.Lists;

import java.util.List;

/**
 * Created by pengtao.geng on 2016/10/27.
 */
public class ListRemoveAllTest {

    public static void main(String[] args) {
        List<Integer> list = Lists.newArrayList(1, 2, 3, 4, 5, 6, 3, 8, 4, 2);
        List<Integer> toRemove = Lists.newArrayList(2, 3, 4);

        System.out.println(list);

        list.removeAll(toRemove);

        System.out.println(list);
    }
}

package com.gpengtao.java;

import com.google.common.collect.Lists;
import org.junit.Test;

import java.util.Collections;
import java.util.List;

/**
 * Created by pengtao.geng on 2016/10/27.
 */
public class ListTest {

    @Test
    public void retain() {
        List<Integer> list1 = Lists.newArrayList(1, 2, 3, 4, 5);
        List<Integer> list2 = Lists.newArrayList(2, 5, 6, 7, 8);

        boolean b = list1.retainAll(list2);
        System.out.println(b);
        System.out.println(list1);
    }

    @Test
    public void sort() {
        List<Integer> list = Lists.newArrayList(8, 4, 1, 6, 2, 4, 5);

        Collections.sort(list);

        System.out.println(list);
    }
}
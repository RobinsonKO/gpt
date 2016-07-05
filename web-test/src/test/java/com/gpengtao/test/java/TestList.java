package com.gpengtao.test.java;

import com.google.common.collect.Lists;
import org.junit.Test;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by pengtao.geng on 2015/11/9.
 */
public class TestList {

    @Test
    public void test_for_each_remove() {
        List<Integer> list = Lists.newArrayList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        for (Integer one : list) {
            if (one > 3) {
                list.remove(one);
            }
        }
        System.out.println(list);
    }

    @Test
    public void ok() {
        List<Integer> list = Lists.newArrayList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        List<Integer> remove = Lists.newArrayList();
        for (Integer one : list) {
            if (one > 3) {
                remove.add(one);
            }
        }
        list.removeAll(remove);
        System.out.println(list);
    }

    @Test
    public void test() {
        List<Integer> list = Lists.newArrayList(4, 5, 6, 7, 8, 9, 10, 1, 2, 3);

        Collections.sort(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });

        System.out.println(list);
    }
}

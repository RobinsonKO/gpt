package com.gpengtao.test.guava;

import com.google.common.base.Predicate;
import com.google.common.base.Splitter;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import org.junit.Test;

import java.util.List;

/**
 * Created by pengtao.geng on 2015/12/2.
 */
public class GuavaTest {

    @Test
    public void test_Iterable() {
        List<Integer> list = Lists.newArrayList(0, 1, 9, 2, 0, 2, 8, 7, 1, 2, 10, 3, 4);
        Iterables.removeIf(list, new Predicate<Integer>() {

            public boolean apply(Integer input) {
                if (input > 3 || input < 2) {
                    return true;
                } else {
                    return false;
                }
            }
        });

        System.out.println(list);
    }

    @Test
    public void test_split_empty_string() {
        Iterable<String> split = Splitter.on(",").split("");
        System.out.println(split);
    }
}

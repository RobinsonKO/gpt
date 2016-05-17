package com.gpengtao.test.guava;

import com.google.common.base.Predicate;
import com.google.common.base.Splitter;
import com.google.common.collect.*;
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

    @Test
    public void test_split() {
        String str = "a|b|c";

        String[] split = str.split("\\|");
        for (String s : split) {
            System.out.println(s);
        }
    }

    @Test
    public void test_multi_map() {
        Ordering<String> natural = Ordering.natural();
        TreeMultimap<String, String> treeMultiMap = TreeMultimap.create(natural, natural);

        treeMultiMap.put("3", "b");
        treeMultiMap.put("3", "a");

        treeMultiMap.put("1", "a");
        treeMultiMap.put("1", "c");
        treeMultiMap.put("1", "b");

        treeMultiMap.put("2", "a");
        treeMultiMap.put("2", "b");

        System.out.println(treeMultiMap);
    }
}

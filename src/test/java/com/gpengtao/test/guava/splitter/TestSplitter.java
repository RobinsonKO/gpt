package com.gpengtao.test.guava.splitter;

import com.google.common.base.Splitter;
import org.junit.Test;

/**
 * Created by pengtao.geng on 2016/5/24.
 */
public class TestSplitter {

    @Test
    public void test_string_split() {
        String str = "a|b|c";

        String[] split = str.split("\\|");
        for (String s : split) {
            System.out.println(s);
        }
    }

    @Test
    public void test_splitter_empty_string() {
        Iterable<String> split = Splitter.on(",").split("");
        System.out.println(split);
    }

    @Test
    public void test_splitter_split_fixed_length() {
        String str = "abc";

        Iterable<String> split = Splitter.fixedLength(2).split(str);

        System.out.println(split);
    }
}

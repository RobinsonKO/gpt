package com.gpengtao.test.other;

import com.gpengtao.model.Book;
import org.junit.Test;

import java.math.BigDecimal;

/**
 * Created by pengtao.geng on 2015/7/7.
 */
public class TestMemory {

    @Test
    public void test() {
        int num = 100;
        char c = 'a';
        long id = 100000L;

        Book book = new Book();
        book.setName("java");
        book.setPrice(new BigDecimal(1000));

        int age = 30;

        int length = 100;
    }

    @Test
    public void test_run_time() {
        Runtime runtime = Runtime.getRuntime();
        System.out.println(runtime);
    }
}

package com.gpengtao.json.test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gpengtao.json.model.Book;
import org.junit.Test;

import java.io.IOException;
import java.util.Date;

/**
 * Created by gpengtao on 16/7/7.
 */
public class MainTest {

    @Test
    public void test_to_json() throws JsonProcessingException {

        Book bean = new Book();
        bean.setName("gpengtao");
        bean.setPrice(100);
        bean.setCreateTime(new Date());
        bean.setWork("no thing");
        bean.setAaa("aaa");

        ObjectMapper mapper = new ObjectMapper();

        String json = mapper.writeValueAsString(bean);

        System.out.println(json);
    }

    @Test
    public void test_parse_json() throws IOException {
        String json = "{\"name\":\"gpengtao\",\"age\":100,\"work\":\"no thing\"}\n";

        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        Book bean = mapper.readValue(json, Book.class);

        System.out.println(bean);
    }
}

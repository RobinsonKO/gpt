package com.gpengtao.web.config;

import com.gpengtao.model.Book;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by gpengtao on 15/8/19.
 */
@Configuration
public class MyWebConfig {

    private final Logger logger = LoggerFactory.getLogger(MyWebConfig.class);

    public MyWebConfig() {
        logger.info("加载");
    }

    @Bean
    public Book book() {
        logger.info("使用MyWebConfig生成了一个book");
        return new Book("Annotation Book");
    }
}

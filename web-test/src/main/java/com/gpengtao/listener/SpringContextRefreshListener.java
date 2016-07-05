package com.gpengtao.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

/**
 * Created by pengtao.geng on 2015/9/7.
 */
public class SpringContextRefreshListener implements ApplicationListener<ContextRefreshedEvent> {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());


    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        logger.info("spring context refresh 完成,event={}", event);
    }
}

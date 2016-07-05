package com.gpengtao.listener;

import com.gpengtao.event.SayHelloEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * Created by gpengtao on 15/3/24.
 */
@Component
public class AppEventListener implements ApplicationListener {

    private static final Logger logger = LoggerFactory.getLogger(AppEventListener.class);

    @Override
    public void onApplicationEvent(ApplicationEvent event) {
        logger.info("app收到event : {}", event);

        if (event instanceof SayHelloEvent) {
            logger.info("收到了sayHello事件");
        }
    }

}

package com.gpengtao.json;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * Created by pengtao.geng on 2015/3/4.
 */
public class RootSpringUtil implements ApplicationContextAware {

    private static Logger logger = LoggerFactory.getLogger(RootSpringUtil.class);

    private static ApplicationContext applicationContext;

    RootSpringUtil() {
        logger.info("RootSpringUtil init ...");
    }

    @Override
    public void setApplicationContext(ApplicationContext context) throws BeansException {
        logger.info("RootSpringUtil set context");
        applicationContext = context;
    }

    public static ApplicationContext getApplicationContext() {
        return applicationContext;
    }
}

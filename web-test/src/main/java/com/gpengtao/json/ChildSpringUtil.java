package com.gpengtao.json;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * Created by pengtao.geng on 2015/3/4.
 */
public class ChildSpringUtil implements ApplicationContextAware {

    private static Logger logger = LoggerFactory.getLogger(ChildSpringUtil.class);

    private static ApplicationContext applicationContext;

    ChildSpringUtil() {
        logger.info("ChildSpringUtil init ...");
    }

    @Override
    public void setApplicationContext(ApplicationContext context) throws BeansException {
        logger.info("ChildSpringUtil set context");
        applicationContext = context;
    }

    public static ApplicationContext getApplicationContext() {
        return applicationContext;
    }
}

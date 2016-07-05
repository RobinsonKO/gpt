package com.gpengtao.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanClassLoaderAware;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.*;
import org.springframework.core.io.ResourceLoader;

/**
 * Created by gpengtao on 15/3/15.
 */
public class SayHeHeService implements BeanNameAware, BeanClassLoaderAware, BeanFactoryAware, ResourceLoaderAware,
        ApplicationEventPublisherAware, MessageSourceAware, ApplicationContextAware {

    private static final Logger logger = LoggerFactory.getLogger(SayHeHeService.class);

    public SayHeHeService() {
        logger.info("SayHeheService init ...");
    }

    @Override
    public void setBeanName(String name) {
        logger.info("SayHeheService 设置的名字是: {}", name);
    }

    @Override
    public void setBeanClassLoader(ClassLoader classLoader) {
        logger.info("SayHeheService使用的classLoader is: {}", classLoader);
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        logger.info("SayHeheService容器 is : {}", beanFactory);
    }

    @Override
    public void setResourceLoader(ResourceLoader resourceLoader) {
        logger.info("SayHeheService容器ResourceLoader is : {}", resourceLoader);
    }

    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        logger.info("SayHeheService的ApplicationEventPublisher is : {}", applicationEventPublisher);
    }

    @Override
    public void setMessageSource(MessageSource messageSource) {
        logger.info("SayHeheService的MessageSource is : {}", messageSource);
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        logger.info("SayHeheService的ApplicationContext is : {}", applicationContext);
    }
}

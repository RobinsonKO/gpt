package com.gpengtao.service;

import com.gpengtao.event.SayHelloEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;
import org.springframework.context.*;
import org.springframework.core.io.ResourceLoader;

import java.util.Date;
import java.util.Locale;

/**
 * Created by gpengtao on 15/3/15.
 */
public class SayHelloService implements BeanNameAware, BeanClassLoaderAware, BeanFactoryAware, ResourceLoaderAware,
        ApplicationEventPublisherAware, MessageSourceAware, ApplicationContextAware, InitializingBean, DisposableBean {

    private static final Logger logger = LoggerFactory.getLogger(SayHelloService.class);

    private ApplicationEventPublisher applicationEventPublisher;

    public SayHelloService() {
        logger.info("SayHelloService init ...");
    }

    @Override
    public void setBeanName(String name) {
        logger.info("SayHelloService set name : {}", name);
    }

    @Override
    public void setBeanClassLoader(ClassLoader classLoader) {
        logger.info("SayHelloService set classLoader : {}", classLoader);
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        logger.info("SayHelloService set beanFactory : {}", beanFactory);
    }

    @Override
    public void setResourceLoader(ResourceLoader resourceLoader) {
        logger.info("SayHelloService set ResourceLoader : {}", resourceLoader);
    }

    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        logger.info("SayHelloService set ApplicationEventPublisher : {}", applicationEventPublisher);
        this.applicationEventPublisher = applicationEventPublisher;
    }

    @Override
    public void setMessageSource(MessageSource messageSource) {
        logger.info(messageSource.getMessage("login.user", null, Locale.CHINA));
        logger.info(messageSource.getMessage("login.user", null, Locale.US));
        logger.info("SayHelloService set MessageSource : {}", messageSource);
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        logger.info("SayHelloService set ApplicationContext : {}", applicationContext);
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        logger.info("SayHelloService afterPropertiesSet");
    }

    public void init() {
        logger.info("SayHelloService init invoked");
    }

    @Override
    public void destroy() throws Exception {
        logger.info("SayHelloService destroy invoked");
    }

    public void release() {
        logger.info("SayHelloService release invoked");
    }

    public void sayHello() {
        logger.info("say了一次Hello");
        applicationEventPublisher.publishEvent(new SayHelloEvent(new Date()));
    }
}

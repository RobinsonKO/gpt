package com.gpengtao.web.controller;

import com.gpengtao.service.CacheService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;
import java.util.Random;

/**
 * Created by pengtao.geng on 2015/1/17.
 */
@Controller
public class TestController {

    private static final Logger logger = LoggerFactory.getLogger(TestController.class);

    @Resource
    private CacheService cache;

    @RequestMapping("/test")
    @ResponseBody
    public String hello(HttpServletRequest request) {
        return "server name:" + request.getServerName() + " | server port:" + request.getServerPort();
    }

    @RequestMapping("/testError")
    @ResponseBody
    public String error() {
        if (new Random(System.currentTimeMillis()).nextBoolean()) {
            throw new NullPointerException();
        } else {
            throw new RuntimeException();
        }
    }

    @RequestMapping("/testCache")
    @ResponseBody
    public String testCache() {
        int value = cache.getValue("hello");
        return "get cache value : " + value;
    }

    @RequestMapping("/simple")
    @ResponseBody
    public String testSimple(HttpServletRequest request) {
        logger.info("TestController invoked ...");

        String contextPath = request.getContextPath();
        logger.info("ContextPath: {}", contextPath);

        String servletPath = request.getServletPath();
        logger.info("ServletPath: {}", servletPath);

        StringBuffer requestURL = request.getRequestURL();
        logger.info("RequestUrl: {}", requestURL.toString());

        String requestURI = request.getRequestURI();
        logger.info("RequestUri: {}", requestURI);

        Enumeration attributeNames = request.getAttributeNames();
        while (attributeNames.hasMoreElements()) {
            String element = (String) attributeNames.nextElement();
            logger.info("Attribute: {} -> {}", element, request.getAttribute(element));
        }

        return "simple";
    }
}

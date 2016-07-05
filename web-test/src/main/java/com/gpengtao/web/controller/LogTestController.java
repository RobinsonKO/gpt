package com.gpengtao.web.controller;

import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.core.util.StatusPrinter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by pengtao.geng on 2015/1/17.
 */
@Controller
public class LogTestController {

    private static final Logger logger = LoggerFactory.getLogger(LogTestController.class);

    @RequestMapping("/logTest")
    @ResponseBody
    public String logTest(HttpServletRequest request) {

        logger.info("访问LogTestController");

        return "logTest";
    }

    @RequestMapping("/logStatus")
    @ResponseBody
    public String logStatus(HttpServletRequest request) {

        logger.info("访问logStatus");

        LoggerContext context = (LoggerContext) LoggerFactory.getILoggerFactory();
        StatusPrinter.print(context);

        return "logStatus";
    }

    @RequestMapping("/logLevel")
    @ResponseBody
    public String logLevel(HttpServletRequest request) {

        ch.qos.logback.classic.Logger l = (ch.qos.logback.classic.Logger) logger;
        logger.info("已经设置的日志级别： {}", l.getLevel());

        l.setLevel(Level.INFO);

        logger.trace("trace 级别 {}", throwException());
        logger.debug("debug 级别");
        logger.info("info 级别");
        logger.warn("warn 级别");
        logger.error("error 级别");

        return "logLevel";
    }

    private String throwException() {
        throw new RuntimeException();
    }


}

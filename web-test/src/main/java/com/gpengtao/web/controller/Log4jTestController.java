package com.gpengtao.web.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by pengtao.geng on 2015/5/13.
 */
@Controller
public class Log4jTestController {
    private static final Logger logger = Logger.getLogger(Log4jTestController.class);

    @RequestMapping("/log4jTest")
    @ResponseBody
    public String logTest(HttpServletRequest request) {

        logger.info("访问log4jTest");

        return "log4jTest";
    }
}

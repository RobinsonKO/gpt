package com.gpengtao.web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by gpengtao on 15/5/26.
 */
public class SimpleController implements Controller {

    private Logger logger = LoggerFactory.getLogger(SimpleController.class);

    @Override
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        logger.info("访问 SimpleController");
        return null;
    }
}

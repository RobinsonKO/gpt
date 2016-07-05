package com.gpengtao.web.controller;

import com.gpengtao.service.SayHelloService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.Date;

@Controller
@RequestMapping("/hello")
public class HelloController {

    private static final Logger logger = LoggerFactory.getLogger(HelloController.class);

    @Value("${name}")
    private String name;

    @Resource
    private SayHelloService sayHelloService;

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public String printWelcome(ModelMap model) {
        model.addAttribute("message", "Hello world!");
        return "printWelcome : hello";
    }

    @RequestMapping(value = "/sayHello", method = RequestMethod.GET)
    @ResponseBody
    public String sayHello() {
        logger.info("访问了say hello");
        sayHelloService.sayHello();
        return "hello " + new Date();
    }

}
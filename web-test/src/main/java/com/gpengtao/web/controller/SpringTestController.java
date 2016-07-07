package com.gpengtao.web.controller;

import com.gpengtao.json.ChildSpringUtil;
import com.gpengtao.json.RootSpringUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by gpengtao on 15/3/11.
 */
@Controller
@RequestMapping("/springTest")
public class SpringTestController {

    private static final Logger logger = LoggerFactory.getLogger(SpringTestController.class);

    @RequestMapping("/bean")
    @ResponseBody
    public String bean() {
        Object userService = RootSpringUtil.getApplicationContext().getBean("userService");
        logger.info("RootSpringUtil 获得 userService:" + userService);

        Object userService1 = ChildSpringUtil.getApplicationContext().getBean("userService");
        logger.info("ChildSpringUtil 获得 userService:" + userService1);

//        Object testController = RootSpringUtil.getApplicationContext().getBean("testController");
//        logger.info("RootSpringUtil 获得 testController:" + testController);

        Object testController1 = ChildSpringUtil.getApplicationContext().getBean("testController");
        logger.info("ChildSpringUtil 获得 testController:" + testController1);

        return "view bean";
    }
}

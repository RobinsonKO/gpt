package com.gpengtao.extract.web.test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by pengtao.geng on 2016/8/29.
 */
@RestController
@RequestMapping("/test")
public class HelloController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @RequestMapping("/now")
    public String hello() {
        logger.info("访问now接口");

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return format.format(new Date());
    }
}

package com.gpengtao.web.controller.time;

import com.google.common.collect.Maps;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

/**
 * Created by pengtao.geng on 2016/8/29.
 */
@RestController
@RequestMapping("/time")
public class TimeController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @RequestMapping(value = "/now")
    public Map<String, Object> hello() {
        logger.info("访问now接口");

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateString = format.format(new Date());

        Map<String, Object> map = Maps.newConcurrentMap();
        map.put("hello", dateString);
        return map;
    }
}
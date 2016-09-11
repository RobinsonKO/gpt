package com.gpengtao.web.controller.time;

import com.google.common.collect.Maps;
import org.apache.commons.lang3.time.DateUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
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

    @InitBinder
    public void binder(WebDataBinder webDataBinder) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        CustomDateEditor customDateEditor = new CustomDateEditor(simpleDateFormat, true);

        webDataBinder.registerCustomEditor(Date.class, customDateEditor);

        logger.info("register editor");
    }

    @RequestMapping("/date")
    public Object date(Date date) {
        return "时间是:" + date;
    }

    @RequestMapping(value = "/now")
    public Map<String, Object> now() {
        logger.info("访问now接口");

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateString = format.format(new Date());

        Map<String, Object> map = Maps.newConcurrentMap();
        map.put("现在时刻", dateString);
        return map;
    }

    @RequestMapping(value = "/yesterday", produces = {"text/html;charset=UTF-8"})
    public Object yesterday() {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date yesterday = DateUtils.addDays(new Date(), -1);
        String str = format.format(yesterday);

        return "昨天是: " + str;
    }

    @RequestMapping(value = "/china")
    public Object china() {
        return "中国";
    }

    @RequestMapping(value = "/say")
    public Object say(String message) {
        logger.info("收到请求say:{}", message);
        return "say " + message;
    }

}

package com.gpengtao.web.controller.time;

import com.google.common.collect.Maps;
import org.apache.commons.lang3.time.DateUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
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

    @RequestMapping(value = "/test", produces = {"application/json;charset=UTF-8"})
    public Object test() {
        long num = System.currentTimeMillis() % 2;
        if (num == 0) {
            return "偶数";
        } else {
            Map<String, String> map = Maps.newHashMap();
            map.put("hello", "奇数");
            return map;
        }
    }

    @RequestMapping(value = "/encoding")
    public Object encoding(HttpServletRequest request) {
        String name = request.getParameter("name");
        logger.info("请求参数name是:{}", name);

        return name;
    }
}

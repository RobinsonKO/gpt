package com.gpengtao.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by gpengtao on 15/1/28.
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @RequestMapping("list")
    @ResponseBody
    public String list(HttpServletRequest request) {
        return "user1 user2";
    }
}

package com.gpengtao.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * Created by gpengtao on 15/1/28.
 */
@Service
public class UserService {

    private static Logger logger = LoggerFactory.getLogger(UserService.class);

    public UserService() {
        logger.info("user service init");
    }

    public String list() {
        return "user";
    }
}

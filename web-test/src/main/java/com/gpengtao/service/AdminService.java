package com.gpengtao.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

/**
 * Created by gpengtao on 3/28/15.
 */
@Service
public class AdminService {

    private static final Logger logger = LoggerFactory.getLogger(AdminService.class);

    @Resource
    private UserService userService;

    public AdminService() {
        logger.info("AdminService init... userService={}", userService);
    }

    @PostConstruct
    public void print() {
        logger.info("In AdminService... userService={}", userService);
    }
}

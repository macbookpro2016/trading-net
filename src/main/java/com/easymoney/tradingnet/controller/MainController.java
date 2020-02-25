package com.easymoney.tradingnet.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description: 主要业务
 * @author: fengzhihang
 * @create: 2020-02-25 17:40
 **/
@RestController
@RequestMapping("main")
public class MainController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @PostMapping("/execute")
    public String execute(){
        logger.info("收到请求");
        return "SUCCESS";
    }

}
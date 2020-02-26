package com.easymoney.tradingnet.controller;

import com.easymoney.tradingnet.service.common.QueryService;
import com.easymoney.tradingnet.service.mail.MailService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @description: 主要业务
 * @author: fengzhihang
 * @create: 2020-02-25 17:40
 **/
@RestController
@RequestMapping("main")
public class MainController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private MailService mailService;
    @Autowired
    private QueryService queryService;

    @PostMapping("/execute")
    public String execute(){
        logger.info("收到请求");
        String fullUrl = "http://fund.eastmoney.com/005911.html?spm=search";
        ResponseEntity responseEntity = restTemplate.getForEntity(fullUrl, String.class);
        String html = (String) responseEntity.getBody();
        int gzStart = html.indexOf("gz_gsz") + 8;
        int gzEnd = gzStart + 6;
        System.out.println("估值:" + html.substring(gzStart, gzEnd));
        int jzStart = html.indexOf("fix_dwjz") + 29;
        int jzEnd = jzStart + 6;
        System.out.println("净值:" + html.substring(jzStart, jzEnd));
        return "SUCCESS";
    }

    @PostMapping("sendMail")
    public String sendMailTest(){
        mailService.sendSimpleMail("15611295706@163.com", "hello World", "网格交易");
        return "SUCCESS";
    }

    @PostMapping("select")
    public String select(){
        queryService.getAllSubScribe();
        return "SUCCESS";
    }

    public static void main(String[] args) {
//        String gz = "id=\"gz_gsz\">3.0350<";
//        int gzStart = gz.indexOf("gz_gsz") + 8;
//        int gzEnd = gzStart + 6;
//        System.out.println("估值" + gz.substring(gzStart, gzEnd));
//        String jz = "</span><span class=\"fix_dwjz  bold ui-color-red\">3.0328</";
//        int jzStart = jz.indexOf("fix_dwjz") + 29;
//        int jzEnd = jzStart + 6;
//        System.out.println("净值:" + jz.substring(jzStart, jzEnd));
    }

}
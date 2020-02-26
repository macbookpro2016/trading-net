package com.easymoney.tradingnet.job;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

/**
 * @description:
 * @author: fengzhihang
 * @create: 2020-02-25 23:32
 **/
@Component
public class TestJob implements MyJob{

    @Value("${daydayfoundurl}")
    private String daydayFoundUrl;

    /**
     * 净值前缀名称
     */
    @Value("${jz.prefix.name}")
    private String jzPrefixName;
    /**
     * 净值前缀长度
     */
    @Value("${jz.prefix.length}")
    private int jzPrefixLength;

    /**
     * 估值前缀名称
     */
    @Value("${gz.prefix.name}")
    private String gzPrefixName;

    /**
     * 估值前缀长度
     */
    @Value("${gz.prefix.length}")
    private int gzPrefixLength;

    /**
     * 估值/净值价格长度
     */
    @Value("${price.length}")
    private int priceLength;


    /**
     * 估值 估算增长率前缀
     */
    @Value("${gz.zzl.prefix.name}")
    private String gzZzlPrefixName;

    /**
     * 估值 估算增长率前缀长度(从prefix到真正的值前面的长度)
     */
    @Value("${gz.zzl.prefix.length}")
    private int gzZzlPrefixLength;

    /**
     * 估值增长率 长度
     */
    @Value("${gz.zzl.length}")
    private int gzZzlLength;

    /**
     * 估值 估算增长值前缀
     */
    @Value("${gz.zze.prefix.name}")
    private String gzZzePrefixName;

    /**
     * 估值 估算增长值前缀长度
     */
    @Value("${gz.zze.prefix.length}")
    private int gzZzePrefixLength;

    /**
     * 估值 估算增长值长度
     */
    @Value("${gz.zze.length}")
    private int gzZzeLength;

    @Autowired
    private RestTemplate restTemplate;

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Scheduled(cron = "0 */3 * * * ?")
    @Override
    public void execute() {
        String code = "005911";
        logger.info("now is :{}", System.currentTimeMillis());
        String fullUrl = String.format(daydayFoundUrl, code);
        ResponseEntity responseEntity = restTemplate.getForEntity(fullUrl, String.class);
        String html = (String) responseEntity.getBody();
        String gz = getData(html, gzPrefixName, gzPrefixLength, priceLength);
        String jz = getData(html, jzPrefixName, jzPrefixLength, priceLength);
        String gzzzl = getData(html, gzZzlPrefixName, gzZzlPrefixLength, gzZzlLength);
        String gzzze = getData(html, gzZzePrefixName, gzZzePrefixLength, gzZzeLength);
        logger.info("净值:{}", jz);
        logger.info("估值:{}", gz);
        logger.info("增长率:{}", gzzzl);
        logger.info("增长值:{}", gzzze);
    }

    /**
     *
     * 获取值
     *
     * @param source 源文本
     * @param prefix 前缀名称
     * @param prefixLength 从prefix到真正的值前面的长度
     * @param dataLength 值长度
     * @return
     */
    public String getData(String source, String prefix, int prefixLength, int dataLength){
        int start = source.indexOf(prefix) + prefixLength;
        int end = start + dataLength;
        return source.substring(start, end);
    }

}
package com.easymoney.tradingnet.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

/**
 * @description: restTemplate配置类
 *
 * @author: fengzhihang
 * @create: 2019-07-10 19:52
 **/
@Configuration
public class HttpRestTemplateConfig {

    private static final Logger LOGGER = LoggerFactory.getLogger(HttpRestTemplateConfig.class);

    @Value("${http.readtimeout}")
    private int readTimeout;

    @Value("${http.connecttimeout}")
    private int connectTimeout;

    @Bean
    public ClientHttpRequestFactory clientHttpRequestFactory() {
        final SimpleClientHttpRequestFactory simpleClientHttpRequestFactory = new SimpleClientHttpRequestFactory();
        simpleClientHttpRequestFactory.setReadTimeout(readTimeout);
        simpleClientHttpRequestFactory.setConnectTimeout(connectTimeout);
        return simpleClientHttpRequestFactory;
    }

    @Bean
    public RestTemplate restTemplate(final ClientHttpRequestFactory factory) {
        LOGGER.info("-----restTemplate init-----");
        return new RestTemplate(factory);
    }





}
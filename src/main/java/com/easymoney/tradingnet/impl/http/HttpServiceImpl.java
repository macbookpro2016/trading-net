package com.easymoney.tradingnet.impl.http;

import com.easymoney.tradingnet.service.http.HttpService;
import com.easymoney.tradingnet.vo.FoundInformationVO;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * @description:
 * @author: fengzhihang
 * @create: 2020-02-28 00:56
 **/
@Service
public class HttpServiceImpl implements HttpService {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${daydayfoundurl}")
    private String daydayFoundUrl;

    /**
     * 净值前缀名称
     */
    @Value("${jz.prefix.name}")
    private String jzPrefixName;

    /**
     * 估值前缀名称
     */
    @Value("${gz.prefix.name}")
    private String gzPrefixName;

    /**
     * 估值 估算增长率前缀
     */
    @Value("${gz.zzl.prefix.name}")
    private String gzZzlPrefixName;

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

    private Logger logger = LoggerFactory.getLogger(this.getClass());



    /**
     * 获取基金信息
     *
     * @param foundCode
     * @param foundName
     */
    @Override
    public FoundInformationVO getFoundInformation(String foundCode, String foundName){
        logger.info("开始查询基金", System.currentTimeMillis());
        String fullUrl = String.format(daydayFoundUrl, foundCode);
        ResponseEntity responseEntity = restTemplate.getForEntity(fullUrl, String.class);
        String html = (String) responseEntity.getBody();
        Document document = Jsoup.parse(html);
        String gzString = document.getElementById(gzPrefixName).text();
        String jzString = document.getElementsByClass(jzPrefixName).text();
        String gzzzlString = document.getElementById(gzZzlPrefixName).text();
        gzzzlString = gzzzlString.substring(0, gzzzlString.length() - 1);
        String gzzzeString = document.getElementById(gzZzePrefixName).text();
        BigDecimal gz = new BigDecimal(gzString).setScale(4, RoundingMode.HALF_UP);
        BigDecimal jz = new BigDecimal(jzString).setScale(4, RoundingMode.HALF_UP);
        BigDecimal gzzzl = new BigDecimal(gzzzlString).setScale(4, RoundingMode.HALF_UP);
        BigDecimal gzzze = new BigDecimal(gzzzeString).setScale(4, RoundingMode.HALF_UP);
        if(gz.compareTo(jz) == -1){
            gzzze = gzzze.negate();
        }
        logger.info("{}:净值:{}", foundName, jz);
        logger.info("{}:估值:{}", foundName, gz);
        logger.info("{}:增长率:{}", foundName, gzzzl);
        logger.info("{}:增长额:{}", foundName, gzzze);
        FoundInformationVO informationVO = new FoundInformationVO();
        informationVO.setFoundCode(foundCode);
        informationVO.setFoundName(foundName);
        informationVO.setGz(gz);
        informationVO.setJz(jz);
        informationVO.setZze(gzzze);
        informationVO.setZzl(gzzzl);
        return informationVO;
    }
}
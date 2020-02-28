package com.easymoney.tradingnet.job;

import com.easymoney.tradingnet.entity.FoundSubscribe;
import com.easymoney.tradingnet.entity.FoundTradeNet;
import com.easymoney.tradingnet.entity.FoundTrendExpectRecord;
import com.easymoney.tradingnet.entity.User;
import com.easymoney.tradingnet.mapper.CustomMapper;
import com.easymoney.tradingnet.mapper.FoundTrendExpectRecordMapper;
import com.easymoney.tradingnet.service.common.QueryService;
import com.easymoney.tradingnet.service.http.HttpService;
import com.easymoney.tradingnet.service.mail.MailService;
import com.easymoney.tradingnet.vo.FoundInformationVO;
import com.easymoney.tradingnet.vo.SimpleFoundVO;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;

/**
 * @description: 2点50执行，按照预设网格对所有订阅信息进行通知
 * @author: fengzhihang
 * @create: 2020-02-25 23:32
 **/
@Component
public class NetTradingNotifyJob implements MyJob{

    @Autowired
    private HttpService httpService;
    @Autowired
    private QueryService queryService;
    @Autowired
    private CustomMapper customMapper;
    @Autowired
    private FoundTrendExpectRecordMapper foundTrendExpectRecordMapper;
    @Autowired
    private MailService mailService;

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    private static Map<String, FoundInformationVO> foundInformationVOMap = new HashMap<>();

    private StringBuffer mailMessage;

    @Scheduled(cron = "0 50 14 * * ?")
    @Transactional
    @Override
    public void execute() {
        /**
         * 必须要间隔10s
         */
        long peroid = 1000 * 10;
        long start;
        long end;
        mailMessage = new StringBuffer();
        try {
            /**
             * 获取所有订阅的基金代码信息
             */
            List<SimpleFoundVO> foundVOList = customMapper.getAllSubscribeFound();
            logger.info("foundVOList:{}", foundVOList);
            if(null == foundVOList){
                return;
            }
            String foundCode;
            String foundName;
            /**
             * 获取每一只基金的信息
             */
            for (SimpleFoundVO simpleFoundVO : foundVOList) {
                foundCode = simpleFoundVO.getFoundCode();
                foundName = simpleFoundVO.getFoundName();
                start = System.currentTimeMillis();
                FoundInformationVO foundInformationVO = httpService.getFoundInformation(foundCode, foundName);
                FoundTrendExpectRecord foundTrendExpectRecord = new FoundTrendExpectRecord();
                foundTrendExpectRecord.setCreateTime(new Date());
                foundTrendExpectRecord.setFoundCode(foundCode);
                foundTrendExpectRecord.setFoundName(foundName);
                foundTrendExpectRecord.setGz(foundInformationVO.getGz());
                foundTrendExpectRecord.setJz(foundInformationVO.getJz());
                foundTrendExpectRecord.setZzl(foundInformationVO.getZzl());
                foundTrendExpectRecord.setZze(foundInformationVO.getZze());
//                foundTrendExpectRecordMapper.insertSelective(foundTrendExpectRecord);
                foundInformationVOMap.put(foundCode, foundInformationVO);
                end = System.currentTimeMillis();
                if((end - start) < peroid){
                    Thread.sleep(peroid - (end - start));
                }
            }
            dealSubscribeInformation();
        }catch (Exception e){
            e.printStackTrace();
            mailMessage = new StringBuffer("网格策略执行异常,错误信息:" + e.getMessage());
            mailService.sendSimpleMailToUser(1L, mailMessage.toString(), "异常信息");
        }finally {
            foundInformationVOMap.clear();
        }
        logger.info("\n" + mailMessage.toString());
    }

    /**
     * 处理每个用户的订阅
     */
    public void dealSubscribeInformation(){
        /**
         * 查询订阅表里所有的用户
         */
        List<Long> subscribeUserIdList = customMapper.getSubscribeUserIdList();
        for(Long userId : subscribeUserIdList){
            List<FoundSubscribe> subscribes = queryService.getSubscribeByUserId(userId);
            User user = queryService.getUserById(userId);
            /**
             * 处理订阅的每一只基金
             */
            mailMessage = new StringBuffer();
            mailMessage.append(user.getNickName() + ",下午好!\n" + "        您一共订阅了" + subscribes.size() + "支基金:\n");
            for(FoundSubscribe subscribe : subscribes){
                String code = subscribe.getFoundCode();
                String name = subscribe.getFoundName();
                FoundInformationVO informationVO = foundInformationVOMap.get(code);
                mailMessage.append("    " + name).append(",代码为:").append(code + "的基金概况为:")
                        .append("净值:" + informationVO.getJz() + ",")
                        .append("估值:" + informationVO.getGz() + ",")
                        .append("增长率:" + informationVO.getZzl() + "%,")
                        .append("增长额:" + informationVO.getZze() + ".");
                Long netId = subscribe.getNetId();
                if(null != netId){
                    FoundTradeNet net = queryService.getNetById(netId);
                    String netName = net.getNetName();
                    String dimension = net.getDimension();
                    BigDecimal height = net.getHight();
                    BigDecimal highest = net.getHighest();
                    BigDecimal zzl = informationVO.getZzl();
                    BigDecimal zze = informationVO.getZze();
                    BigDecimal gz = informationVO.getGz();
                    BigDecimal jz = informationVO.getJz();
                    mailMessage.append("根据您的网格交易策略: " + netName);
                    if("0".equals(dimension)){
                        // 按照增长率计算
                        if(!(zzl.abs().compareTo(height.abs()) == -1)){
                            // 满足
                            mailMessage.append(",已满足网格高度:" + net.getHight());
                            if(zzl.abs().compareTo(highest) == 1){
                                // 大于最大波动
                                mailMessage.append("但是已大于您设定的最大波动值: " + highest.abs() + ",所以不建议进行交易\n");
                            }else {
                                mailMessage.append("且在设置的波动范围内: " + highest.abs() + ",所以建议进行 ");
                                if(gz.compareTo(jz) == -1){
                                    mailMessage.append("加仓\n");
                                }else {
                                    mailMessage.append("减仓\n");
                                }
                            }
                        }else {
                            // 不满足
                            mailMessage.append(",未满足网格高度:" + net.getHight() + ",所以不建议进行交易\n");
                        }
                    }else {
                        BigDecimal lowest = net.getLowest();
                        if(!(zze.abs().compareTo(height.abs()) == -1)){
                            mailMessage.append(",已满足网格高度:" + net.getHight());
                            if(zze.abs().compareTo(highest.abs()) == 1){
                                mailMessage.append("但是已大于您设定的最大值: " + highest.abs() + ",所以不建议进行交易\n");
                            }else if(zze.abs().compareTo(lowest.abs()) == -1){
                                mailMessage.append("但是已大于您设定的最小值: " + lowest.abs() + ",所以不建议进行交易\n");
                            }else {
                                mailMessage.append("且在设置的价格范围内,所以建议进行 ");
                                if(gz.compareTo(jz) == -1){
                                    mailMessage.append("加仓\n");
                                }else {
                                    mailMessage.append("减仓\n");
                                }
                            }
                        }else {
                            mailMessage.append(",未满足网格高度:" + net.getHight() + ",所以不建议进行交易\n");
                        }
                    }
                }else {
                    mailMessage.append("您未设定网格交易策略,无法给出交易建议.\n");
                }
            }
            mailService.sendSimpleMailToUser(userId, mailMessage.toString(), "今日网格交易建议");
        }

    }


    public static void main(String[] args) {
        String s = "hah\nwhat";
        System.out.println(s);
    }



}
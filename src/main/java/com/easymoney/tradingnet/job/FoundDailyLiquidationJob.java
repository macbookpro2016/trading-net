package com.easymoney.tradingnet.job;

import com.easymoney.tradingnet.entity.FoundTrendExpectRecord;
import com.easymoney.tradingnet.entity.UserFoundAssets;
import com.easymoney.tradingnet.service.common.QueryService;
import com.easymoney.tradingnet.service.http.HttpService;
import com.easymoney.tradingnet.service.mail.MailService;
import com.easymoney.tradingnet.vo.FoundInformationVO;
import com.easymoney.tradingnet.vo.SimpleFoundVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @description: 每日3点5分清算用户当日股票收益
 * @author: fengzhihang
 * @create: 2020-02-28 00:44
 **/
@Component
public class FoundDailyLiquidationJob implements MyJob {
    @Autowired
    private QueryService queryService;

    @Autowired
    private HttpService httpService;

    @Autowired
    private MailService mailService;


    private Logger logger = LoggerFactory.getLogger(this.getClass());

    private static Map<String, FoundInformationVO> foundInformationVOMap = new HashMap<>();

    private StringBuffer mailMessage;

    @Override
    public void execute() {
        try {
            /**
             *  查询用户资产表所有的股票信息
             */
            List<SimpleFoundVO> foundVOList = queryService.getAllAssetsFoundList();
            /**
             * 获取每一只基金的信息
             */
            String foundCode;
            String foundName;
            Long start;
            Long end;
            long peroid = 1000 * 10;
            mailMessage = new StringBuffer();
            for (SimpleFoundVO simpleFoundVO : foundVOList) {
                foundCode = simpleFoundVO.getFoundCode();
                foundName = simpleFoundVO.getFoundName();
                start = System.currentTimeMillis();
                FoundInformationVO foundInformationVO = httpService.getFoundInformation(foundCode, foundName);
                foundInformationVOMap.put(foundCode, foundInformationVO);
                end = System.currentTimeMillis();
                if((end - start) < peroid){
                    Thread.sleep(peroid - (end - start));
                }
            }
            dealUserAssets();
        }catch (Exception e){
            e.printStackTrace();
            mailMessage = new StringBuffer("清算执行异常,错误信息:" + e.getMessage());
            mailService.sendSimpleMailToUser(1L, mailMessage.toString(), "异常信息");
        }finally {
            foundInformationVOMap.clear();
        }
        logger.info("\n" + mailMessage.toString());
    }

    private void dealUserAssets(){
        List<Long> userIdList = queryService.getAssetsUserIdList();
        for(Long userId : userIdList){
            List<UserFoundAssets> assetsList = queryService.getAssetsByUserId(userId);
        }
    }


}
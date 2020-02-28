package com.easymoney.tradingnet.service.common;

import com.easymoney.tradingnet.entity.FoundSubscribe;
import com.easymoney.tradingnet.entity.FoundTradeNet;
import com.easymoney.tradingnet.entity.User;
import com.easymoney.tradingnet.entity.UserFoundAssets;
import com.easymoney.tradingnet.vo.SimpleFoundVO;

import java.util.List;

/**
 * @description: 查询方法
 * @author: fengzhihang
 * @create: 2020-02-26 18:41
 **/
public interface QueryService {

    List<FoundSubscribe> getAllSubscribe();

    List<FoundSubscribe> getSubscribeByUserId(Long userId);

    List<UserFoundAssets> getAssetsByUserId(Long userId);

    User getUserById(Long userId);

    FoundTradeNet getNetById(Long netId);

    List<SimpleFoundVO> getAllAssetsFoundList();

    List<Long> getAssetsUserIdList();

}
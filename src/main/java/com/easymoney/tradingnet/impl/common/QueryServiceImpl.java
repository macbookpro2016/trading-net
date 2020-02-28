package com.easymoney.tradingnet.impl.common;

import com.easymoney.tradingnet.entity.*;
import com.easymoney.tradingnet.mapper.*;
import com.easymoney.tradingnet.service.common.QueryService;
import com.easymoney.tradingnet.vo.SimpleFoundVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @description:
 * @author: fengzhihang
 * @create: 2020-02-26 18:43
 **/
@Service
public class QueryServiceImpl implements QueryService {

    @Autowired
    private FoundSubscribeMapper foundSubscribeMapper;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private FoundTradeNetMapper foundTradeNetMapper;
    @Autowired
    private CustomMapper customMapper;
    @Autowired
    private UserFoundAssetsMapper userFoundAssetsMapper;

    @Override
    public List<FoundSubscribe> getAllSubscribe() {
        return foundSubscribeMapper.selectByExample(new FoundSubscribeExample());
    }

    @Override
    public List<FoundSubscribe> getSubscribeByUserId(Long userId) {
        if(null == userId){
            return null;
        }
        FoundSubscribeExample example = new FoundSubscribeExample();
        FoundSubscribeExample.Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false);
        criteria.andUserIdEqualTo(userId);
        return foundSubscribeMapper.selectByExample(example);
    }

    @Override
    public List<UserFoundAssets> getAssetsByUserId(Long userId) {
        if(null == userId){
            return null;
        }
        UserFoundAssetsExample example = new UserFoundAssetsExample();
        UserFoundAssetsExample.Criteria criteria = example.createCriteria();
        criteria.andUserIdEqualTo(userId);
        return userFoundAssetsMapper.selectByExample(example);
    }

    @Override
    public User getUserById(Long userId) {
        return userMapper.selectByPrimaryKey(userId);
    }

    @Override
    public FoundTradeNet getNetById(Long netId) {
        return foundTradeNetMapper.selectByPrimaryKey(netId);
    }

    @Override
    public List<SimpleFoundVO> getAllAssetsFoundList() {
        return customMapper.getAllAssetsFoundList();
    }

    @Override
    public List<Long> getAssetsUserIdList() {
        return customMapper.getAssetsUserIdList();
    }
}
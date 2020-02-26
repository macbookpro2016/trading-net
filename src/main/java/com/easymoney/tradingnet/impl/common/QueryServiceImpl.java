package com.easymoney.tradingnet.impl.common;

import com.easymoney.tradingnet.entity.FoundSubscribe;
import com.easymoney.tradingnet.entity.FoundSubscribeExample;
import com.easymoney.tradingnet.mapper.FoundSubscribeMapper;
import com.easymoney.tradingnet.service.common.QueryService;
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

    @Override
    public List<FoundSubscribe> getAllSubScribe() {

        foundSubscribeMapper.selectByExample(new FoundSubscribeExample());
        return null;
    }
}
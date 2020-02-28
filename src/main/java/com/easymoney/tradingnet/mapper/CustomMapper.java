package com.easymoney.tradingnet.mapper;

import com.easymoney.tradingnet.vo.SimpleFoundVO;

import java.util.List;

public interface CustomMapper {

    List<SimpleFoundVO> getAllSubscribeFound();

    List<Long> getSubscribeUserIdList();

    List<Long> getAssetsUserIdList();

    List<SimpleFoundVO> getAllAssetsFoundList();
}

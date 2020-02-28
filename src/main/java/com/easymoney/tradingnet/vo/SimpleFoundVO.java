package com.easymoney.tradingnet.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * @description:
 * @author: fengzhihang
 * @create: 2020-02-26 23:33
 **/
@Data
public class SimpleFoundVO implements Serializable {

    private static final long serialVersionUID = -1787496602087612770L;

    private String foundCode;

    private String foundName;
}
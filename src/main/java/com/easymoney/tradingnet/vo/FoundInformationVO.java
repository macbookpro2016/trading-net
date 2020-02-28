package com.easymoney.tradingnet.vo;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @description: 查询基金信息输出vo
 * @author: fengzhihang
 * @create: 2020-02-26 21:10
 **/
@Data
public class FoundInformationVO implements Serializable {

    private static final long serialVersionUID = 2721475311392916662L;

    private String foundCode;

    private String foundName;

    /**
     * 估值
     */
    private BigDecimal gz;

    /**
     * 净值
     */
    private BigDecimal jz;

    /**
     * 增长率
     */
    private BigDecimal zzl;

    /**
     * 增长额
     */
    private BigDecimal zze;
}
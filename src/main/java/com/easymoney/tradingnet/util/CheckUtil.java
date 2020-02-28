package com.easymoney.tradingnet.util;

import java.util.Collection;

/**
 * @description:
 * @author: fengzhihang
 * @create: 2020-02-26 23:10
 **/
public class CheckUtil {

    public static boolean isEmpty(String source) {
        return source == null || source.length() == 0;
    }

    public static boolean isEmpty(Collection<?> source) {
        return source == null || source.isEmpty();
    }

}
package com.easymoney.tradingnet.service.mail;

/**
 * @description: 邮件
 * @author: fengzhihang
 * @create: 2020-02-26 14:36
 **/
public interface MailService {

    /**
     * 发送简单文本邮件
     *
     * @param toAddress 收件人
     * @param content 内容
     * @param subject 主题
     */
    void sendSimpleMail(String toAddress, String content, String subject);

}
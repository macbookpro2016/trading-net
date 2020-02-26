package com.easymoney.tradingnet.impl.mail;

import com.easymoney.tradingnet.service.mail.MailService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

/**
 * @description:
 * @author: fengzhihang
 * @create: 2020-02-26 14:41
 **/
@Service
public class MailServiceImpl implements MailService {

    @Autowired
    private JavaMailSender mailSender;

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public void sendSimpleMail(String toAddress, String content, String subject) {
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setTo(toAddress);
        mailMessage.setText(content);
        mailMessage.setSubject(subject);
        mailMessage.setFrom("trading_net@163.com");
        try {
            mailSender.send(mailMessage);
        }catch (Exception e){
            e.printStackTrace();
        }

        logger.info("发送成功");
    }
}
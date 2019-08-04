package com.seventh.sunday.service.impl;

import com.alibaba.fastjson.JSON;
import com.seventh.sunday.service.MailService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

/**
 * @author ami
 */
@Service
@Slf4j
public class MailServiceImpl implements MailService {

    @Autowired
    JavaMailSender javaMailSender;

    @Override
    public void sendSimpleMail(String from, String to, String cc, String subject, String content) {
        try {
            SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
            simpleMailMessage.setFrom(from);
            simpleMailMessage.setTo(to);
            if (StringUtils.isNotBlank(cc)) {
                simpleMailMessage.setCc(cc);
            }
            simpleMailMessage.setSubject(subject);
            simpleMailMessage.setText(content);
            if (log.isDebugEnabled()) {
                log.debug("发送简单邮件{}, {}", JSON.toJSONString(simpleMailMessage), LocalDateTime.now());
            }
            javaMailSender.send(simpleMailMessage);
        } catch (Exception e) {
            log.error("发送简单邮件异常", e);
        }

    }
}

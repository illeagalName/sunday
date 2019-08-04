package com.seventh.sunday.service;

/**
 * @author ami
 */
public interface MailService {
    /**
     * 发送简单的邮件
     *
     * @param from    发件人
     * @param to      收件人
     * @param cc      抄送人
     * @param subject 邮件主题
     * @param content 邮件内容
     */
    void sendSimpleMail(String from, String to, String cc, String subject, String content);
}

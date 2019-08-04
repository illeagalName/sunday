package com.seventh.sunday;

import com.alibaba.rocketmq.client.exception.MQBrokerException;
import com.alibaba.rocketmq.client.exception.MQClientException;
import com.alibaba.rocketmq.client.producer.DefaultMQProducer;
import com.alibaba.rocketmq.client.producer.SendResult;
import com.alibaba.rocketmq.common.message.Message;
import com.alibaba.rocketmq.remoting.exception.RemotingException;
import com.seventh.sunday.service.MailService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class SundayApplicationTests {

    @Test
    public void contextLoads() {
    }

    @Autowired
    DefaultMQProducer defaultMQProducer;

    @Autowired
    MailService mailService;

    /**
     * 测试发送mq消息
     *
     * @throws InterruptedException
     * @throws RemotingException
     * @throws MQClientException
     * @throws MQBrokerException
     */
    @Test
    public void mqSend() throws InterruptedException, RemotingException, MQClientException, MQBrokerException {
        String msg = "demo msg test";
        log.info("开始发送消息：" + msg);
        Message sendMsg = new Message("SEVEN_TOPIC_TEST", "TEST_TAG", msg.getBytes());
        //默认3秒超时
        SendResult sendResult = defaultMQProducer.send(sendMsg);
        log.info("消息发送响应信息：" + sendResult.toString());
    }

    @Test
    public void mailSend(){
        mailService.sendSimpleMail("211770756@qq.com","675431871@qq.com",null,"测试邮件主题","测试邮件内容");
    }

}

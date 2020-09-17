package com.seventh.sunday;

import com.alibaba.rocketmq.client.exception.MQBrokerException;
import com.alibaba.rocketmq.client.exception.MQClientException;
import com.alibaba.rocketmq.client.producer.DefaultMQProducer;
import com.alibaba.rocketmq.client.producer.SendResult;
import com.alibaba.rocketmq.common.message.Message;
import com.alibaba.rocketmq.remoting.exception.RemotingException;
import com.seventh.sunday.event.OrderCallBackEvent;
import com.seventh.sunday.listener.*;
import com.seventh.sunday.service.MailService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

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
        String msg = "人事纷纷，你总太天真。往后的余生，我只要你。。。。";
        log.info("开始发送消息：" + msg);
        Message sendMsg = new Message("SEVEN_TOPIC_TEST", "TEST_TAG", msg.getBytes());
        //默认3秒超时
        SendResult sendResult = defaultMQProducer.send(sendMsg);
        log.info("消息发送响应信息：" + sendResult.toString());
    }

    @Test
    public void mailSend() {
        mailService.sendSimpleMail("ywdong1019@qq.com", "1974625107@qq.com", null, "测试邮件主题", "测试邮件内容");
    }

    @Test
    public void eventExecute() {
        List<AbstractEventListener> listeners = new ArrayList<>();
        listeners.add(new UpdateOrderStatusListener(1));
        listeners.add(new NotifyStockModifyListener(3));
        listeners.add(new ShareProfitCalculateListener(2));

        ListenerManager manager = new ListenerManager(listeners);
        OrderCallBackEvent event = new OrderCallBackEvent("" + System.currentTimeMillis());
        manager.handleEvent(event);
    }

}

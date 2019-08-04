package com.seventh.sunday;

import com.alibaba.rocketmq.client.exception.MQBrokerException;
import com.alibaba.rocketmq.client.exception.MQClientException;
import com.alibaba.rocketmq.client.producer.DefaultMQProducer;
import com.alibaba.rocketmq.client.producer.SendResult;
import com.alibaba.rocketmq.common.message.Message;
import com.alibaba.rocketmq.remoting.exception.RemotingException;
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
    private DefaultMQProducer defaultMQProducer;

    @Test
    public void send() throws InterruptedException, RemotingException, MQClientException, MQBrokerException {
        String msg = "demo msg test";
        log.info("开始发送消息："+msg);
        Message sendMsg = new Message("SEVEN_TOPIC_TEST","TEST_TAG",msg.getBytes());
        //默认3秒超时
        SendResult sendResult = defaultMQProducer.send(sendMsg);
        log.info("消息发送响应信息："+sendResult.toString());
    }


}

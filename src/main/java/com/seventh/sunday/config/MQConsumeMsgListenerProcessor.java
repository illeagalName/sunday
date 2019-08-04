package com.seventh.sunday.config;

import com.alibaba.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import com.alibaba.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import com.alibaba.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import com.alibaba.rocketmq.common.message.MessageExt;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Slf4j
public class MQConsumeMsgListenerProcessor implements MessageListenerConcurrently {

    @Value("${rocketmq.consumer.topic}")
    private String topic;

    @Override
    public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> msgs, ConsumeConcurrentlyContext consumeConcurrentlyContext) {
        if (CollectionUtils.isEmpty(msgs)) {
            log.info("接收到的消息为空，不做任何处理");
            return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
        }
        for (MessageExt messageExt : msgs) {
            String topic = messageExt.getTopic();
            String tag = messageExt.getTags();
            String msg = new String(messageExt.getBody());
            System.out.println("*********************************");
            System.out.println("消费响应：msgId : " + messageExt.getMsgId() + ",  msgBody : " + msg + ",	tag:" + tag + ", topic:" + topic);
            System.out.println("*********************************");
        }

//                int reconsumeTimes = messageExt.getReconsumeTimes();
//                if(reconsumeTimes == 3){
//                    return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
//                }
        //TODO 处理对应的业务逻辑


        return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
    }
}

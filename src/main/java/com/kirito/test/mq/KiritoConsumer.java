package com.kirito.test.mq;

import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Service;

/**
 * @author kirito
 * @date 2023-08-21 11:06:53
 * @desc ...
 */
@Service
@Slf4j
@RocketMQMessageListener(consumerGroup = "${rocketmq.consumer.group}",
        topic = "${rocketmq.consumer.test-topic}")
public class KiritoConsumer implements RocketMQListener<String> {

    @Override
    public void onMessage(String s) {
        log.info("receive msg ==>{}", s);
    }

}

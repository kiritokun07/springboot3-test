package com.kirito.test.mq;

import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.spring.annotation.ConsumeMode;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Service;

import java.util.Random;

/**
 * @author kirito
 * @date 2023-08-21 11:06:53
 * @desc ...
 */
@Service
@Slf4j
@RocketMQMessageListener(consumerGroup = "${rocketmq.consumer.group}",
        topic = "${rocketmq.consumer.test-topic}",
        consumeMode= ConsumeMode.ORDERLY)
public class KiritoConsumer implements RocketMQListener<String> {

    @Override
    public void onMessage(String s) {
        Random random = new Random(6);
        try {
            Thread.sleep(random.nextInt(10));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        log.info("receive msg ==>{}", s);
    }

}

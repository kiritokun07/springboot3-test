package com.kirito.test.controller;

import com.kirito.test.config.MyProperties;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author kirito
 * @date 2023-08-21 10:45:29
 * @desc ...
 */
@RestController
@RequestMapping("/mq")
@Slf4j
@RequiredArgsConstructor
public class ProducerController {

    private final MyProperties myProperties;
    @Autowired
    private RocketMQTemplate rocketMQTemplate;

    @Autowired
    private DefaultMQProducer defaultMqProducer;

    @GetMapping("/test1")
    public String test1() {
        //用Message会报错
        //Message<String> message = MessageBuilder
        //        .withPayload("蛤蛤蛤")
        //        .setHeader(RocketMQHeaders.KEYS, String.valueOf(System.currentTimeMillis() / 1000))
        //        .build();
        rocketMQTemplate.convertAndSend(myProperties.getTestTopic(), "蛤蛤蛤");
        log.info("OK");
        return "OK";
    }

    @GetMapping("/test2")
    public String test2() throws Exception {
        Message message = new Message();
        message.setTopic(myProperties.getTestTopic());
        //message.setTags("boot-mq-tag");
        message.setKeys(String.valueOf(System.currentTimeMillis() / 1000));
        message.setBody("蛤蛤蛤2".getBytes());
        // 发送消息，打印日志
        SendResult sendResult = defaultMqProducer.send(message);
        log.info("OK2");
        return "OK2";
    }
}

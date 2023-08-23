package com.kirito.test.controller;

import com.kirito.test.config.MyProperties;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
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

    //并发消息
    @GetMapping("/test2")
    public String test2() throws Exception {
        for (int i = 0; i < 100; i++) {
            String timestamp = String.valueOf(i);
            Message message = new Message();
            message.setTopic(myProperties.getTestTopic());
            //message.setTags("boot-mq-tag");
            message.setKeys(timestamp);
            message.setBody(timestamp.getBytes());
            // 发送消息，打印日志
            defaultMqProducer.send(message);
            //defaultMqProducer.send(message, (mqs, msg, arg) -> {
            //    int id = Math.abs(arg.hashCode());
            //    long index = id % mqs.size();
            //    return mqs.get((int) index);
            //}, "123456789");
        }
        log.info("OK2");
        return "OK2";
    }

    //RocketMQ 顺序消费
    //https://www.jianshu.com/p/a1bfa60cb39b
    //顺序消息
    @GetMapping("/test3")
    public String test3() throws Exception {
        for (int i = 0; i < 100; i++) {
            String timestamp = String.valueOf(i);
            Message message = new Message();
            message.setTopic(myProperties.getTestTopic());
            //message.setTags("boot-mq-tag");
            message.setKeys(timestamp);
            message.setBody(timestamp.getBytes());
            // 发送消息，打印日志
            //defaultMqProducer.send(message);
            defaultMqProducer.send(message, (mqs, msg, arg) -> {
                int id = Math.abs(arg.hashCode());
                long index = id % mqs.size();
                return mqs.get((int) index);
            }, "123456789");
        }
        log.info("OK2");
        return "OK2";
    }
}

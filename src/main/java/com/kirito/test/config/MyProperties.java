package com.kirito.test.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author kirito
 * @date 2023-08-21 11:11:17
 * @desc ...
 */
@Component
@Data
public class MyProperties {

    @Value("${rocketmq.consumer.test-topic}")
    private String testTopic;

}

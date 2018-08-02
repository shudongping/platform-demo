package com.shu.springboot.platform.rabbitmq;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @author shudongping
 * @date 2018/07/30
 */
@Service
@Slf4j
public class MQSender {

    @Autowired
    private AmqpTemplate amqpTemplate;


    public void sendMiaoshaMessage(String msg) {
        log.info("send message:" + msg);
        amqpTemplate.convertAndSend(MQConfig.QUEUE, msg);
    }

}

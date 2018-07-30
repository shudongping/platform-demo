package com.shu.springboot.platform.rabbitmq;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author shudongping
 * @date 2018/07/30
 */
@Service
@Slf4j
public class MQSender {

    @Autowired
    private AmqpTemplate amqpTemplate ;



    public void sendMiaoshaMessage(String msg) {
        log.info("send message:"+msg);
        amqpTemplate.convertAndSend(MQConfig.QUEUE, msg);
    }


}

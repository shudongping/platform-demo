package com.shu.springboot.platform.rabbitmq;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @author shudongping
 * @date 2018/07/30
 */
@Service
@Slf4j
public class MQReceiver {


    @RabbitListener(queues=MQConfig.QUEUE)
    public void receive(String message){

        log.info("接收到消息了，{}",message);

    }


}

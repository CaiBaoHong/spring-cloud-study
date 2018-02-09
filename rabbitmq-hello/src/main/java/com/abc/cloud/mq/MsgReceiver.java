package com.abc.cloud.mq;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@RabbitListener(queues = "hello")
@Component
public class MsgReceiver {

    @RabbitHandler
    public void process(String content){
        System.out.println(this+" MsgReceiver receiver <-- "+content);
    }

}

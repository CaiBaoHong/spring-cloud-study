package com.abc.cloud.mq;


import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class MsgSender {

    @Autowired
    private AmqpTemplate amqpTemplate;

    public void send(){
        System.out.println("AmqpTemplate: "+amqpTemplate);
        String content = "hello amqp "+new Date();
        System.out.println("MsgSender send --> "+content);
        amqpTemplate.convertAndSend("hello",content);
    }


}

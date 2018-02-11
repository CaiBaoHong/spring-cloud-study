package com.abc.cloud.stream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;

@EnableBinding(Sink.class)
public class SinkReceiver {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @StreamListener(Sink.INPUT)
    public void receive(Object playload){
        logger.info("Receive: "+playload);

    }


}

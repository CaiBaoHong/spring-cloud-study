package com.abc.cloud.controller;

import com.abc.cloud.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ConsumerController {

    @Autowired
    private HelloService helloService;

    @GetMapping("/ribbon-consumer")
    public String helloConsumer(){
        return helloService.hello();
    }

}

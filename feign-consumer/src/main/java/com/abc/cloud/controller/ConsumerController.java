package com.abc.cloud.controller;

import com.abc.cloud.model.User;
import com.abc.cloud.service.HelloService;
import com.abc.cloud.service.IHelloService;
import com.abc.cloud.service.RefactorHelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConsumerController {

    @Autowired
    private HelloService helloService;
    @Autowired
    private RefactorHelloService refactorHelloService;

    @GetMapping("/feign-consumer")
    public String helloConsumer(){
        return helloService.hello();
    }

    @GetMapping("/feign-consumer2")
    public String helloConsumer2(){
        StringBuilder sb = new StringBuilder();
        sb.append(helloService.hello()).append("-----");
        sb.append(helloService.hello("Tom")).append("-----");
        sb.append(helloService.hello("Tom",30)).append("-----");
        sb.append(helloService.hello(new User("Tom",30))).append("-----");
        return sb.toString();
    }

    @GetMapping("/feign-consumer3")
    public String helloConsumer3(){
        StringBuilder sb = new StringBuilder();
        sb.append(refactorHelloService.hello("Rose")).append("-----");
        sb.append(refactorHelloService.hello("Rose",18)).append("-----");
        sb.append(refactorHelloService.hello(new User("Jack",17))).append("-----");
        return sb.toString();
    }

}

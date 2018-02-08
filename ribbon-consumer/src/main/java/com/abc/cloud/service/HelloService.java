package com.abc.cloud.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class HelloService {

    @Autowired
    private RestTemplate restTemplate;


    @HystrixCommand(fallbackMethod = "helloFallback")
    public String hello(){
        return restTemplate.getForEntity("http://HELLO-SERVICE:/hello",String.class).getBody();
    }

    public String helloFallback(){
        return "hello error (fallback)";
    }



}

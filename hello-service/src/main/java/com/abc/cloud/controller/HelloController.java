package com.abc.cloud.controller;

import com.abc.cloud.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.serviceregistry.Registration;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class HelloController {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private Registration registration;
    @Autowired
    private DiscoveryClient client;

    @GetMapping("/hello")
    public String hello() {
        String serviceId = registration.getServiceId();
        List<ServiceInstance> instances = client.getInstances(serviceId);
        instances.forEach(inst->{
            System.out.println("Service Instance ==> host: "+inst.getHost()+", serviceId: "+inst.getServiceId());
        });
        return "Hello World";
    }

    @GetMapping("/hello1")
    public String hello1(@RequestParam String name) {
        return "Hello "+name;
    }

    @GetMapping("/hello2")
    public User hello2(@RequestHeader String name, @RequestHeader Integer age) {
        return new User(name,age);
    }

    @PostMapping("/hello3")
    public String hello3(@RequestBody User user) {
        return "Hello "+user.getName()+", "+user.getAge();
    }

}

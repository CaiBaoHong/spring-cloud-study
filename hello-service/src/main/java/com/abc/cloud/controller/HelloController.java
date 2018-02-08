package com.abc.cloud.controller;

import com.netflix.discovery.EurekaClient;
import com.netflix.discovery.converters.Auto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.serviceregistry.Registration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

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

}

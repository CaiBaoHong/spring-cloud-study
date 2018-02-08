package com.abc.cloud.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient("HELLO-SERVICE")
public interface HelloService {

    @GetMapping("/hello")
    String hello();

}

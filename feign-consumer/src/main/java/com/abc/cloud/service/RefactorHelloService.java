package com.abc.cloud.service;

import org.springframework.cloud.netflix.feign.FeignClient;

@FeignClient("HELLO-SERVICE")
public interface RefactorHelloService extends IHelloService {
}

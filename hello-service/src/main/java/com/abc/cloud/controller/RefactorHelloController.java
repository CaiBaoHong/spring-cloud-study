package com.abc.cloud.controller;

import com.abc.cloud.model.User;
import com.abc.cloud.service.IHelloService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RefactorHelloController implements IHelloService {


    @Override
    public String hello(@RequestParam("name") String name) {
        return "Refactor Hello "+name;
    }

    @Override
    public User hello(@RequestHeader("name")String name, @RequestHeader("age")Integer age) {
        return new User("Refactor "+name,age);
    }

    @Override
    public String hello(@RequestBody User user) {
        return "Refactor "+user.getName()+", "+user.getAge();
    }
}

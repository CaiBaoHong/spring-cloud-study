package com.abc.cloud.service;

import com.abc.cloud.model.User;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/refactor")
public interface IHelloService {

    @GetMapping("/hello4")
    String hello(@RequestParam("name") String name);

    @GetMapping("/hello5")
    User hello(@RequestHeader("name") String name, @RequestHeader("age") Integer age);

    @PostMapping("/hello6")
    String hello(@RequestBody User user);

}

package com.zeaho.spring.springbootdemo.controller;

import com.zeaho.spring.springbootdemo.service.HelloService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author LuZhong
 */
@RestController
@RequestMapping("/hello")
public class HelloController {
    private final HelloService helloService;

    public HelloController(HelloService helloService) {
        this.helloService = helloService;
    }

    @GetMapping("/world")
    public String world(@RequestParam("name") String name) {
        return helloService.sayHello(name);
    }
}

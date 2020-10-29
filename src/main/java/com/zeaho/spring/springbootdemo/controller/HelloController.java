package com.zeaho.spring.springbootdemo.controller;

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
    @GetMapping("/world")
    public String world(@RequestParam("name") String name) {
        return String.format("hello world! hello %s!", name);
    }
}

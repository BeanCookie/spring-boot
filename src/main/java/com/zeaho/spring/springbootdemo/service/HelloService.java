package com.zeaho.spring.springbootdemo.service;

import org.springframework.stereotype.Service;

/**
 * @author LuZhong
 */
@Service
public class HelloService {
    public String sayHello(String name) {
        return String.format("hello world! hello %s!", name);
    }
}

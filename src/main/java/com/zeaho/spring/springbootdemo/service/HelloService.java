package com.zeaho.spring.springbootdemo.service;

import com.zeaho.spring.service.TranslateService;
import org.springframework.stereotype.Service;

/**
 * @author LuZhong
 */
@Service
public class HelloService {
    private final TranslateService translateService;

    public HelloService(TranslateService translateService) {
        this.translateService = translateService;
    }

    public String sayHello(String name) {
        return String.format("hello world! hello %s!", translateService.translate(name));
    }
}

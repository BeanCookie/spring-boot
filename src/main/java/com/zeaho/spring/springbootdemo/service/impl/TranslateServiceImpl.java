package com.zeaho.spring.springbootdemo.service.impl;

import com.zeaho.spring.springbootdemo.service.TranslateService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * @author LuZhong
 */
@Service
public class TranslateServiceImpl implements TranslateService {
    private final Logger logger = LoggerFactory.getLogger(TranslateServiceImpl.class);
    @Value("${appKey}")
    private String appKey;

    @Value("${appSecret}")
    private String appSecret;

    @Value("${youdaoUrl}")
    private String youdaoUrl;
    @Override
    public String translate(String text) {
        logger.info("{} {} {}", appKey, appSecret, youdaoUrl);
        return String.format("translate: %s", text);
    }
}

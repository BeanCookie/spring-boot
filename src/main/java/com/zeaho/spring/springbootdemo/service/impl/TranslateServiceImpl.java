package com.zeaho.spring.springbootdemo.service.impl;

import com.zeaho.spring.springbootdemo.properties.YouDaoTranslateProperties;
import com.zeaho.spring.springbootdemo.service.TranslateService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * @author LuZhong
 */
@Service
public class TranslateServiceImpl implements TranslateService {
    private final Logger logger = LoggerFactory.getLogger(TranslateServiceImpl.class);
    private final YouDaoTranslateProperties youDaoTranslateProperties;

    public TranslateServiceImpl(YouDaoTranslateProperties youDaoTranslateProperties) {
        this.youDaoTranslateProperties = youDaoTranslateProperties;
    }

    @Override
    public String translate(String text) {
        logger.info("{} {} {}", youDaoTranslateProperties.getAppKey(), youDaoTranslateProperties.getAppSecret(), youDaoTranslateProperties.getYoudaoUrl());
        return String.format("translate: %s", text);
    }
}

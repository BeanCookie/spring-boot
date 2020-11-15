package com.zeaho.spring.springbootdemo.service;

/**
 * @author LuZhong
 */
public interface TranslateService {
    /**
     * 讲给定的汉字翻译成英文
     * @param text
     * @return
     */
    String translate(String text);
}

package com.gx.demo01.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: gx
 * @Date: Created in 2020/3/23 21:15
 * @Description: 日志测试类
 */
@RestController
public class LogController {

    private Logger logger = LoggerFactory.getLogger(LogController.class);

    @RequestMapping("/log.do")
    public String log(){
        //日志级别从低到高分为TRACE < DEBUG < INFO < WARN < ERROR < FATAL，如果设置为WARN，则低于WARN的信息都不会输出。
        logger.trace("日志输出 trace");
        logger.debug("日志输出 debug");
        logger.info("日志输出 info");
        logger.warn("日志输出 warn");
        logger.error("日志输出 error");
        return "日志level测试";
    }
}

package com.gx.demo01.controller;

import com.gx.demo01.util.DBConnector;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: gx
 * @Date: Created in 2020/3/12 20:49
 * @Description: profile 多环境配置案例
 */
// 可以打成jar包，使用 java -jar XXX.jar --spring.profiles.active=prod/dev 来设置application.properties属性，确认激活那一个环境
@RestController
public class ProfileController {

    @Autowired
    private DBConnector connector;

    @RequestMapping("profile.do")
    public String profile(){
        return connector.configure();
    }
}

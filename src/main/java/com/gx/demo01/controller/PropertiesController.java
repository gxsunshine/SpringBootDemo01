package com.gx.demo01.controller;

import com.gx.demo01.model.ConfigBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: gx
 * @Date: Created in 2020/3/12 16:31
 * @Description: Spring boot 属性配置练习
 */
@RestController
public class PropertiesController {

    // 通过注解@Value(value="${config.name}")可以把属性配置的值绑定到对应的属性上
    @Value("${com.gx.name}")
    private String name;
    @Value("${com.gx.want}")
    private String want;

    @Autowired
    private ConfigBean configBean;

    /**
     * 使用@Value注解直接对属性赋值
     * @return
     */
    @RequestMapping("want.do")
    public String want(){
        return name + "," + want + "!";
    }


    /**
     * 直接 @ConfigurationProperties(prefix = "com.gx") 注解对bean进行赋值
     * @return
     */
    @RequestMapping("want2.do")
    public String want2(){
        return configBean.getName() + "," + configBean.getWant() + "!";
    }

    /**
     * 数据文件中属性组合
     * @return
     */
    @RequestMapping("say.do")
    public String say(){
        return configBean.getSay();
    }

    /**
     * 数据文件中属性组合 -- 使用自定义配置文件
     * @return
     */
    @RequestMapping("say2.do")
    public String say2(){
        return configBean.getSay();
    }
}

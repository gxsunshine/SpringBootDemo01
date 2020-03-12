package com.gx.demo01.model;


import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * @Author: gx
 * @Date: Created in 2020/3/12 17:05
 * @Description: 配置Bean类
 */
// 使用@ConfigurationProperties指明使用那一个前缀
@ConfigurationProperties(prefix = "com.gx")
// 指定配置文件，默认为application.properties，注意这里优先级application.properties > my.properties。如果有相同的属性配置，会被优先级高的覆盖
@PropertySource("classpath:my.properties")
@Component
public class ConfigBean {
    private String name;
    private String want;

    private String say;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWant() {
        return want;
    }

    public void setWant(String want) {
        this.want = want;
    }

    public String getSay() {
        return say;
    }

    public void setSay(String say) {
        this.say = say;
    }

    @Override
    public String toString() {
        return "ConfigBean{" +
                "name='" + name + '\'' +
                ", want='" + want + '\'' +
                ", say='" + say + '\'' +
                '}';
    }
}

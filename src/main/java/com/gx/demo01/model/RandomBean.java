package com.gx.demo01.model;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * @Author: gx
 * @Date: Created in 2020/3/12 18:31
 * @Description: 随机值Bean
 */
// 注意这里prefix不能使用random已有的系统类，不然会报错
@ConfigurationProperties(prefix = "my.random")
@PropertySource("classpath:my.properties")
@Component
public class RandomBean {

    private int  numberInt;
    private long numberLong;
    private String uuid;
    private int numberLessThanTen;
    private int numberInRange;

    public int getNumberInt() {
        return numberInt;
    }

    public void setNumberInt(int numberInt) {
        this.numberInt = numberInt;
    }

    public long getNumberLong() {
        return numberLong;
    }

    public void setNumberLong(long numberLong) {
        this.numberLong = numberLong;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public int getNumberLessThanTen() {
        return numberLessThanTen;
    }

    public void setNumberLessThanTen(int numberLessThanTen) {
        this.numberLessThanTen = numberLessThanTen;
    }

    public int getNumberInRange() {
        return numberInRange;
    }

    public void setNumberInRange(int numberInRange) {
        this.numberInRange = numberInRange;
    }

    @Override
    public String toString() {
        return "RandomBean{" +
                "numberInt=" + numberInt +
                ", numberLong=" + numberLong +
                ", uuid='" + uuid + '\'' +
                ", numberLessThanTen=" + numberLessThanTen +
                ", numberInRange=" + numberInRange +
                '}';
    }
}

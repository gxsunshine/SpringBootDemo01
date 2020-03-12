package com.gx.demo01.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

/**
 * @Author: gx
 * @Date: Created in 2020/3/12 20:40
 * @Description: 线上环境数据库连接器
 */
@Component
// @profile 标签表示当 spring.profiles.active=prod 时，使用的是application-prod.properties的配置环境
@Profile("prod")
public class ProdDBConnector implements DBConnector {

    @Value("${db.url}")
    private String url;

    @Override
    public String configure() {
        return url;
    }
}

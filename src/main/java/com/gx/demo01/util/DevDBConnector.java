package com.gx.demo01.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

/**
 * @Author: gx
 * @Date: Created in 2020/3/12 20:40
 * @Description: 开发环境数据库连接器
 */
@Component
// @profile 标签表示当 spring.profiles.active=dev 时，使用的是application-dev.properties的配置环境
@Profile("dev")
public class DevDBConnector implements DBConnector {

    @Value("${db.url}")
    private String url;

    @Override
    public String configure() {
          return url;
        }
}

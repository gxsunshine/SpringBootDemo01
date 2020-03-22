package com.gx.demo01;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.boot.builder.SpringApplicationBuilder;
//import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

// @SpringBootApplication 是Spring Boot项目的核心注解，主要目的是开启自动配置
@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}


//@SpringBootApplication
//public class Application extends SpringBootServletInitializer {
//
//    public static void main(String[] args) {
//		SpringApplication.run(Application.class, args);
//	}
//
//	@Override
//    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
//        return builder.sources(Application.class);
//    }
//
//}
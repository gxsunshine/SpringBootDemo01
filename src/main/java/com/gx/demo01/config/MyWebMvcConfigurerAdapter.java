package com.gx.demo01.config;

import com.gx.demo01.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @Author: gx
 * @Date: Created in 2020/3/20 18:48
 * @Description: 继承WebMvcConfigurerAdapter类，增加额外配置
 */
@Configuration
public class MyWebMvcConfigurerAdapter extends WebMvcConfigurerAdapter {

    /**
     * 配置静态访问资源
     * @param registry
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        // 配置项目内静态资源目录
//        registry.addResourceHandler("/img/**").addResourceLocations("classpath:/myResources/");

        // 配置静态目录绝对路径 - 项目外
        registry.addResourceHandler("/img/**").addResourceLocations("file:/photo/");
        super.addResourceHandlers(registry);
    }

    /**
     * 配置页面跳转
     * 以前要访问一个页面需要创建一个Controller控制类，再写方法跳转到页面
     * 这样配置后就不需要那么麻烦了，直接访问即可
     * @param registry
     */
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/toLogin.do").setViewName("login");
        super.addViewControllers(registry);
    }

    /**
     * 拦截器
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // addPathPatterns 用于添加拦截规则
        // excludePathPatterns 排除指定拦截路径
//        registry.addInterceptor(new LoginInterceptor()).addPathPatterns("/**").excludePathPatterns("/toLogin.do","/login.do");
        super.addInterceptors(registry);
    }
}

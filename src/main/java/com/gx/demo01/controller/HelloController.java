package com.gx.demo01.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: gx
 * @Date: Created in 2020/3/12 15:16
 * @Description: Hello Controller类
 */
// @RestController注解等价于@Controller+@ResponseBody的结合，使用这个注解的类里面的方法都会以json的格式输出
@RestController
public class HelloController {
    Logger logger = LoggerFactory.getLogger(HelloController.class);
    @RequestMapping("hello.do")
    public String test(){
        logger.info("[info] ---- hello word");
        return "hello12345";
    }
}

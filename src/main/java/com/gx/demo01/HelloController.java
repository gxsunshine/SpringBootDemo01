package com.gx.demo01;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: gx
 * @Date: Created in 2020/3/12 15:16
 * @Description:
 */
@RestController
public class HelloController {

    @RequestMapping("hello.do")
    public String test(){
        return "hello";
    }
}

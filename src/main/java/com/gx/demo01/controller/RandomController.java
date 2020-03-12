package com.gx.demo01.controller;

import com.gx.demo01.model.RandomBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: gx
 * @Date: Created in 2020/3/12 18:28
 * @Description: 随机值Controller
 */
@RestController
public class RandomController {

    @Autowired
    private RandomBean randomBean;

    @RequestMapping("randomValue.do")
    public String randomValue(){
        return randomBean.toString();
    }
}

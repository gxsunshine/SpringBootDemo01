package com.gx.demo01.controller;

import com.gx.demo01.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

/**
 * @Author: gx
 * @Date: Created in 2020/3/22 22:45
 * @Description:
 */
@RestController
public class LoginController {

    @RequestMapping("/login.do")
    public String login(HttpServletRequest request){
        User user = new User("gx","123456");
        request.getSession().setAttribute("user",user);
        return "登录成功";
    }

    @RequestMapping("logout.do")
    public String logout(HttpServletRequest request){
        User user = (User)request.getSession().getAttribute("user");
        if(null != user){
            request.getSession().removeAttribute("user");
        }
        return "注销成功";
    }
}

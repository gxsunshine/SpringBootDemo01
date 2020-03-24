package com.gx.demo01.controller;

import com.gx.demo01.model.LearnResource;
import com.gx.demo01.service.LearnService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: gx
 * @Date: Created in 2020/3/13 11:35
 * @Description: 学习资源controller -- thymeleaf和Jsp 测试
 */
@RestController
public class LearnResourceController {

    @Autowired
    private LearnService learnService;

    @RequestMapping("learnList.do")
    public ModelAndView learnReasourceList(){
        List<LearnResource> learnList = new ArrayList<LearnResource>();
        LearnResource bean =new LearnResource("官方参考文档","Spring Boot Reference Guide","http://docs.spring.io/spring-boot/docs/1.5.1.RELEASE/reference/htmlsingle/#getting-started-first-application");
        learnList.add(bean);
        bean =new LearnResource("官方SpriongBoot例子","官方SpriongBoot例子","https://github.com/spring-projects/spring-boot/tree/master/spring-boot-samples");
        learnList.add(bean);
        bean =new LearnResource("龙国学院","Spring Boot 教程系列学习","http://www.roncoo.com/article/detail/125488");
        learnList.add(bean);
        bean =new LearnResource("嘟嘟MD独立博客","Spring Boot干货系列 ","http://tengj.top/");
        learnList.add(bean);
        bean =new LearnResource("后端编程嘟","Spring Boot教程和视频 ","http://www.toutiao.com/m1559096720023553/");
        learnList.add(bean);
        bean =new LearnResource("程序猿DD","Spring Boot系列","http://www.roncoo.com/article/detail/125488");
        learnList.add(bean);
        bean =new LearnResource("纯洁的微笑","Sping Boot系列文章","http://www.ityouknow.com/spring-boot");
        learnList.add(bean);
        bean =new LearnResource("CSDN——小当博客专栏","Sping Boot学习","http://blog.csdn.net/column/details/spring-boot.html");
        learnList.add(bean);
        bean =new LearnResource("梁桂钊的博客","Spring Boot 揭秘与实战","http://blog.csdn.net/column/details/spring-boot.html");
        learnList.add(bean);
        bean =new LearnResource("林祥纤博客系列","从零开始学Spring Boot ","http://412887952-qq-com.iteye.com/category/356333");
        learnList.add(bean);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/learnResourceList");
        modelAndView.addObject("learnList", learnList);
        return modelAndView;
    }

    @RequestMapping(value = "/queryLeanList.do",method = RequestMethod.POST,produces="application/json;charset=UTF-8")
    public List<LearnResource> queryLearnList(HttpServletRequest request , HttpServletResponse response){
        String author = request.getParameter("author");
        String title = request.getParameter("title");
        Map<String,Object> params = new HashMap<String,Object>();
        params.put("author", author);
        params.put("title", title);
        List<LearnResource> learnList=learnService.querylearnResourceList(params);
        return learnList;
    }
    /**
     * 新添教程
     * @param request
     * @param response
     */
    @RequestMapping(value = "/add.do",method = RequestMethod.POST)
    public String addLearn(HttpServletRequest request , HttpServletResponse response){
        String author = request.getParameter("author");
        String title = request.getParameter("title");
        String url = request.getParameter("url");

        LearnResource learnResource = new LearnResource();
        learnResource.setAuthor(author);
        learnResource.setTitle(title);
        learnResource.setUrl(url);
        int index=learnService.add(learnResource);
        return "结果="+index;

    }
    /**
     * 修改教程
     * @param request
     * @param response
     */
    @RequestMapping(value = "/update.do",method = RequestMethod.POST)
    public String updateLearn(HttpServletRequest request , HttpServletResponse response){
        int id = Integer.parseInt(request.getParameter("id"));
        LearnResource learnResource=learnService.querylearnResourceById(id);
        String author = request.getParameter("author");
        String title = request.getParameter("title");
        String url = request.getParameter("url");
        learnResource.setAuthor(author);
        learnResource.setTitle(title);
        learnResource.setUrl(url);
        int index=learnService.update(learnResource);
        return "修改结果="+index;

    }
    /**
     * 删除教程
     * @param request
     * @param response
     */
    @RequestMapping(value="/delete.do",method = RequestMethod.POST)
    public String deleteUser(HttpServletRequest request ,HttpServletResponse response){
        String ids = request.getParameter("ids");
        System.out.println("ids==="+ids);
        //删除操作
        int index = learnService.deleteByIds(ids);
        return "删除结果"+index;

    }
}

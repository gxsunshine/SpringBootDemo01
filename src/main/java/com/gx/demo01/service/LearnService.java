package com.gx.demo01.service;

import com.gx.demo01.dao.LearnDao;
import com.gx.demo01.dao.LearnDaoByAnnotation;
import com.gx.demo01.model.LearnResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @Author: gx
 * @Date: Created in 2020/3/24 21:18
 * @Description: learn service层
 */
@Service
public class LearnService {

    @Autowired
    LearnDao learnDao;

    @Autowired
    LearnDaoByAnnotation learnDaoByAnnotation;

    public int add(LearnResource learnResource) {
        // JdbcTemplate 方式
//        return this.learnDao.add(learnResource);
        // mybatis 注解方式
        return this.learnDaoByAnnotation.add(learnResource);
    }

    public int update(LearnResource learnResource) {
        // JdbcTemplate 方式
//        return this.learnDao.update(learnResource);
        return this.learnDaoByAnnotation.update(learnResource);
    }

    public int deleteByIds(String[] ids) {
        // JdbcTemplate 方式
//        return this.learnDao.deleteByIds(ids);
        // mybatis 注解方式
        return this.learnDaoByAnnotation.deleteByIds(ids);
    }

    public LearnResource querylearnResourceById(int id) {
        // JdbcTemplate 方式
//        return this.learnDao.queryLearnResourceById(id);
        // mybatis 注解方式
        return this.learnDaoByAnnotation.queryLearnResourceById(id);
    }

    public List<LearnResource> querylearnResourceList(Map<String,Object> params) {
        // JdbcTemplate 方式
//        return this.learnDao.queryLearnResourceList(params);
        // mybatis 注解方式
        return this.learnDaoByAnnotation.queryLearnResourceList(params);
    }
}

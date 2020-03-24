package com.gx.demo01.service;

import com.gx.demo01.dao.LearnDao;
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

    public int add(LearnResource learnResource) {
        return this.learnDao.add(learnResource);
    }

    public int update(LearnResource learnResource) {
        return this.learnDao.update(learnResource);
    }

    public int deleteByIds(String ids) {
        return this.learnDao.deleteByIds(ids);
    }

    public LearnResource querylearnResourceById(int id) {
        return this.learnDao.queryLearnResourceById(id);
    }

    public List<LearnResource> querylearnResourceList(Map<String,Object> params) {
        return this.learnDao.queryLearnResourceList(params);
    }
}

package com.gx.demo01.dao;

import com.gx.demo01.model.LearnResource;

import java.util.List;
import java.util.Map;

/**
 * @Author: gx
 * @Date: Created in 2020/3/24 20:53
 * @Description: 学习资源dao层接口
 */
public interface LearnDao {

    int add(LearnResource learnResouce);
    int update(LearnResource learnResouce);
    int deleteByIds(String ids);
    LearnResource queryLearnResourceById(int id);
    List<LearnResource> queryLearnResourceList(Map<String,Object> params);
}

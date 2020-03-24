package com.gx.demo01.dao;

import com.gx.demo01.model.LearnResource;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @Author: gx
 * @Date: Created in 2020/3/24 20:57
 * @Description: 学习资源dao层接口实现类 - 使用JdbcTemplate实现数据的增删改查
 */
@Repository
public class LearnDaoImpl implements LearnDao{

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public int add(LearnResource learnResouce) {
        return jdbcTemplate.update("insert into learn_resource(author, title,url) values(?, ?, ?)",learnResouce.getAuthor(),learnResouce.getTitle(),learnResouce.getUrl());
    }

    @Override
    public int update(LearnResource learnResouce) {
        return jdbcTemplate.update("update learn_resource set author=?,title=?,url=? where id = ?",learnResouce.getAuthor(),learnResouce.getTitle(),learnResouce.getUrl(),learnResouce.getId());
    }

    @Override
    public int deleteByIds(String ids) {
        return jdbcTemplate.update("delete from learn_resource where id in("+ids+")");
    }

    @Override
    public LearnResource queryLearnResourceById(int id) {
        List<LearnResource> list = jdbcTemplate.query("select * from learn_resource where id = ?", new Object[]{id}, new BeanPropertyRowMapper(LearnResource.class));
        if(null != list && list.size()>0){
            LearnResource learnResource = list.get(0);
            return learnResource;
        }else{
            return null;
        }
    }

    @Override
    public List<LearnResource> queryLearnResourceList(Map<String, Object> params) {
        StringBuffer sql =new StringBuffer();
        sql.append("select * from learn_resource where 1=1");
        if(!StringUtils.isEmpty((String)params.get("author"))){
            sql.append(" and author like '%").append((String)params.get("author")).append("%'");
        }
        if(!StringUtils.isEmpty((String)params.get("title"))){
            sql.append(" and title like '%").append((String)params.get("title")).append("%'");
        }
        // 第二个参数表示指定返回参数的类型
        List<LearnResource> list = jdbcTemplate.query(sql.toString(), new BeanPropertyRowMapper(LearnResource.class));
        return list;
    }
}

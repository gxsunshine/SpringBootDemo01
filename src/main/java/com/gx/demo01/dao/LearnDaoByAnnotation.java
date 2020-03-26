package com.gx.demo01.dao;

import com.gx.demo01.model.LearnResource;
import org.apache.commons.lang.StringUtils;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * @Author: gx
 * @Date: Created in 2020/3/24 20:53
 * @Description: 学习资源dao层接口 通过mybatis注解的方式实现对数据库操作
 */
@Component
@Mapper
public interface LearnDaoByAnnotation {

    /**
     * 简单的语句只需要使用@Insert、@Update、@Delete、@Select这4个注解即可，但是有些复杂点需要动态SQL语句，
     * 就比如上面方法中根据查询条件是否有值来动态添加sql的，就需要使用@InsertProvider、@UpdateProvider、@DeleteProvider、@SelectProvider等注解。
     * 这些可选的 SQL 注解允许你指定一个类名和一个方法在执行时来返回运行 允许创建动态 的 SQL。
     * 基于执行的映射语句, MyBatis 会实例化这个类,然后执行由 provider 指定的方法.
     * 该方法可以有选择地接受参数对象.(In MyBatis 3.4 or later, it’s allow multiple parameters) 属性: type,method。type 属性是类。
     * method 属性是方法名。
     */
    @Insert("insert into learn_resource(author, title,url) values(#{author},#{title},#{url})")
    int add(LearnResource learnResouce);

    @Update("update learn_resource set author=#{author},title=#{title},url=#{url} where id = #{id}")
    int update(LearnResource learnResouce);

    @DeleteProvider(type = LearnSqlBuilder.class, method = "deleteByids")
    int deleteByIds(@Param("ids") String[] ids);

    @Select("select * from learn_resource where id = #{id}")
    @Results(id = "learnMap", value = {
            @Result(column = "id", property = "id", javaType = Integer.class),
            @Result(property = "author", column = "author", javaType = String.class),
            @Result(property = "title", column = "title", javaType = String.class)
    })
    LearnResource queryLearnResourceById(int id);

    @SelectProvider(type = LearnSqlBuilder.class, method = "queryLearnResouceByParams")
    List<LearnResource> queryLearnResourceList(Map<String, Object> params);

    class LearnSqlBuilder {
        public String queryLearnResouceByParams(final Map<String, Object> params) {
            StringBuffer sql =new StringBuffer();
            sql.append("select * from learn_resource where 1=1");
            if(StringUtils.isNotEmpty((String) params.get("author"))){
                sql.append(" and author like '%").append((String)params.get("author")).append("%'");
            }
            if(StringUtils.isNotEmpty((String) params.get("title"))){
                sql.append(" and title like '%").append((String)params.get("title")).append("%'");
            }
            System.out.println("查询sql=="+sql.toString());
            return sql.toString();
        }

        //删除的方法
        public String deleteByids(@Param("ids") final String[] ids){
            StringBuffer sql =new StringBuffer();
            sql.append("DELETE FROM learn_resource WHERE id in(");
            for (int i=0;i<ids.length;i++){
                if(i==ids.length-1){
                    sql.append(ids[i]);
                }else{
                    sql.append(ids[i]).append(",");
                }
            }
            sql.append(")");
            return sql.toString();
        }
    }
}

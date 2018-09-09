package com.example.demo.mapper;

import com.example.demo.bean.MkUser;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

/**
 * 以注解的方式
 * @author: monkey
 * @date: 2018/9/9 21:21
 */
@Mapper
public interface MkUserMapper {

    @Insert(value = "insert into mk_user(name,create_time) values(#{name,jdbcType=VARCHAR},#{createTime,jdbcType=TIMESTAMP})")
    int insert(MkUser mkUser);

    @Select(value = "select id, name, create_time from mk_user where id = #{id,jdbcType=INTEGER}")
    //由于日期类型特殊，所以需要这里指定，int和string不用
    @Results(value = {@Result(column = "create_time",property = "createTime",jdbcType = JdbcType.TIMESTAMP )})
    MkUser selectByPrimaryKey(int id);

}

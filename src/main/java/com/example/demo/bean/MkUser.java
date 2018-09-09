package com.example.demo.bean;

import java.io.Serializable;
import java.util.Date;

/**
 * 测试mybatis的实体类
 * @author: monkey
 * @date: 2018/9/9 21:17
 */
public class MkUser implements Serializable {

    private int id;

    private String name;

    private Date createTime;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "MkUser{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", createTime=" + createTime +
                '}';
    }
}

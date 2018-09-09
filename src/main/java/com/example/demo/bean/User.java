package com.example.demo.bean;

import java.util.Date;

/**
 * @author: monkey
 * @date: 2018/9/2 10:54
 */
public class User {

    /**
     *
     */
    private int id;

    private String name;

    private Date birthday;

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

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }
}

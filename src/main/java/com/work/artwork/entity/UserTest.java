package com.work.artwork.entity;

import java.io.Serializable;

/**
 * (UserTest)实体类
 *
 * @author makejava
 * @since 2020-03-31 17:05:34
 */
public class UserTest implements Serializable {
    private static final long serialVersionUID = 445608247197392572L;
    /**
    * 主键
    */
    private Integer userId;
    /**
    * 名字
    */
    private String name;
    /**
    * 性别，0男，1女
    */
    private Object set;
    /**
    * 年龄
    */
    private Object age;
    /**
    * 状态，0有效，1隐藏，9删除
    */
    private Object status;


    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Object getSet() {
        return set;
    }

    public void setSet(Object set) {
        this.set = set;
    }

    public Object getAge() {
        return age;
    }

    public void setAge(Object age) {
        this.age = age;
    }

    public Object getStatus() {
        return status;
    }

    public void setStatus(Object status) {
        this.status = status;
    }

}
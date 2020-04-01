package com.work.artwork.entity;

import lombok.Data;

import java.util.Date;
import java.io.Serializable;

/**
 * 用户表(SysUser)实体类
 *
 * @author makejava
 * @since 2020-04-01 11:30:06
 */
@Data
public class SysUser implements Serializable {
    private static final long serialVersionUID = -20513176816218902L;
    /**
    * 编号
    */
    private Integer id;
    /**
    * 登录名
    */
    private String username;
    /**
    * 密码
    */
    private String password;
    /**
    * 名称
    */
    private String name;
    
    private String status;
    
    private String delflag;
    
    private String usertype;
    
    private String createby;
    
    private Date createdate;
    
    private String updateby;
    
    private String addresscode;
    
    private Date updatedate;
    
    private String addressdetail;

}
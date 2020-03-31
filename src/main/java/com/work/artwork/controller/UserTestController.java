package com.work.artwork.controller;

import com.work.artwork.entity.UserTest;
import com.work.artwork.service.UserTestService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (UserTest)表控制层
 *
 * @author makejava
 * @since 2020-03-31 17:05:49
 */
@RestController
@RequestMapping("userTest")
public class UserTestController {
    /**
     * 服务对象
     */
    @Resource
    private UserTestService userTestService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public UserTest selectOne(Integer id) {
        return this.userTestService.queryById(id);
    }

}
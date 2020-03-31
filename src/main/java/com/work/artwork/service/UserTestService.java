package com.work.artwork.service;

import com.work.artwork.entity.UserTest;
import java.util.List;

/**
 * (UserTest)表服务接口
 *
 * @author makejava
 * @since 2020-03-31 17:05:34
 */
public interface UserTestService {

    /**
     * 通过ID查询单条数据
     *
     * @param userId 主键
     * @return 实例对象
     */
    UserTest queryById(Integer userId);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<UserTest> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param userTest 实例对象
     * @return 实例对象
     */
    UserTest insert(UserTest userTest);

    /**
     * 修改数据
     *
     * @param userTest 实例对象
     * @return 实例对象
     */
    UserTest update(UserTest userTest);

    /**
     * 通过主键删除数据
     *
     * @param userId 主键
     * @return 是否成功
     */
    boolean deleteById(Integer userId);

}
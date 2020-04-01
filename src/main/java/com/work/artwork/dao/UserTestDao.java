package com.work.artwork.dao;

import com.work.artwork.entity.UserTest;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (UserTest)表数据库访问层
 *
 * @author makejava
 * @since 2020-03-31 17:05:34
 */
@Mapper
public interface UserTestDao {

    /**
     * 通过ID查询单条数据
     *
     * @param userId 主键
     * @return 实例对象
     */
    UserTest queryById(Integer userId);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<UserTest> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param userTest 实例对象
     * @return 对象列表
     */
    List<UserTest> queryAll(UserTest userTest);

    /**
     * 新增数据
     *
     * @param userTest 实例对象
     * @return 影响行数
     */
    int insert(UserTest userTest);

    /**
     * 修改数据
     *
     * @param userTest 实例对象
     * @return 影响行数
     */
    int update(UserTest userTest);

    /**
     * 通过主键删除数据
     *
     * @param userId 主键
     * @return 影响行数
     */
    int deleteById(Integer userId);

}
package com.work.artwork.dao;

import com.work.artwork.entity.SysUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;
import java.util.Map;

/**
 * 用户表(SysUser)表数据库访问层
 *
 * @author makejava
 * @since 2020-04-01 11:30:06
 */
@Mapper
public interface SysUserDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    SysUser queryById(Integer id);

    /**
     * 通过实例查询单条数据
     *
     * @param sysUser 实例对象
     * @return 实例对象
     */
    SysUser queryByModel(SysUser sysUser);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<SysUser> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param sysUser 实例对象
     * @return 对象列表
     */
    List<SysUser> queryAll(SysUser sysUser);

    /**
     * 新增数据
     *
     * @param sysUser 实例对象
     * @return 影响行数
     */
    int insert(SysUser sysUser);

    /**
     * 修改数据
     *
     * @param sysUser 实例对象
     * @return 影响行数
     */
    int update(SysUser sysUser);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

    /**
     * 功能描述：获得总数
     */
    Integer queryListCount(Map<String, Object> condition);

    /**
     * 功能描述： 获得列表数据
     */
    List<SysUser> queryListData(Map<String, Object> condition);

    /**
     * 校验账号
     */
    Integer checkNo(SysUser sysUser);

}
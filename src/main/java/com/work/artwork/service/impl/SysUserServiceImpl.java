package com.work.artwork.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.work.artwork.common.model.SysUserConstans;
import com.work.artwork.dao.SysUserDao;
import com.work.artwork.entity.SysUser;
import com.work.artwork.service.SysUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 用户表(SysUser)表服务实现类
 *
 * @author makejava
 * @since 2020-04-01 11:30:06
 */
@Service("sysUserService")
public class SysUserServiceImpl implements SysUserService {
    @Resource
    private SysUserDao sysUserDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public SysUser queryById(Integer id) {
        return this.sysUserDao.queryById(id);
    }

    /**
     * 通过实例查询单条数据
     *
     * @param sysUser 实例对象
     * @return 实例对象
     */
    @Override
    public List<SysUser> queryByModel(SysUser sysUser){
        return this.sysUserDao.queryAll(sysUser);
    }

    /**
     * 功能描述：查询列表数据
     */
    public JSONObject queryListData(SysUser sysUser, int page, int limit) {
        // 1、定义数据格式
        JSONObject jsonObject = new JSONObject();
        // layui列表json格式：{"code":0,"msg":"","count":总数,"data":[{对象},{...},{对象}]}
        jsonObject.put("code", 0);
        jsonObject.put("msg", "");

        // 2、设置查询条件
        Map<String, Object> condition = new HashMap<String, Object>();
        condition.put("userName", sysUser.getUsername());
        condition.put("name", sysUser.getName());
        condition.put("status", SysUserConstans.USER_STATUS.NORMAL.getCode());
        condition.put("page", (page - 1) * limit);
        condition.put("limit", limit);

        // 3、查询总数
        int count = sysUserDao.queryListCount(condition);
        jsonObject.put("count", count);

        // 4、查询分页数据
        List<SysUser> sysUserList = sysUserDao.queryListData(condition);

        jsonObject.put("data", sysUserList);
        return jsonObject;
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<SysUser> queryAllByLimit(int offset, int limit) {
        return this.sysUserDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param sysUser 实例对象
     * @return 实例对象
     */
    @Override
    public SysUser insert(SysUser sysUser) {
        this.sysUserDao.insert(sysUser);
        return sysUser;
    }

    /**
     * 修改数据
     *
     * @param sysUser 实例对象
     * @return 实例对象
     */
    @Override
    public SysUser update(SysUser sysUser) {
        this.sysUserDao.update(sysUser);
        return this.queryById(sysUser.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.sysUserDao.deleteById(id) > 0;
    }

    /**
     * 校验账号
     * @param sysUser
     * @return
     */
    public Integer checkNo(SysUser sysUser) {
        return this.sysUserDao.checkNo(sysUser);
    }
}
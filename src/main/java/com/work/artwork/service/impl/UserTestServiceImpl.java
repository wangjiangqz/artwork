package com.work.artwork.service.impl;

import com.work.artwork.dao.UserTestDao;
import com.work.artwork.entity.UserTest;
import com.work.artwork.service.UserTestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * (UserTest)表服务实现类
 *
 * @author makejava
 * @since 2020-03-31 17:05:44
 */
@Service("userTestService")
public class UserTestServiceImpl implements UserTestService {
    @Autowired
    private UserTestDao userTestDao;

    /**
     * 通过ID查询单条数据
     *
     * @param userId 主键
     * @return 实例对象
     */
    @Override
    public UserTest queryById(Integer userId) {
        return this.userTestDao.queryById(userId);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<UserTest> queryAllByLimit(int offset, int limit) {
        return this.userTestDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param userTest 实例对象
     * @return 实例对象
     */
    @Override
    public UserTest insert(UserTest userTest) {
        this.userTestDao.insert(userTest);
        return userTest;
    }

    /**
     * 修改数据
     *
     * @param userTest 实例对象
     * @return 实例对象
     */
    @Override
    public UserTest update(UserTest userTest) {
        this.userTestDao.update(userTest);
        return this.queryById(userTest.getUserId());
    }

    /**
     * 通过主键删除数据
     *
     * @param userId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer userId) {
        return this.userTestDao.deleteById(userId) > 0;
    }
}
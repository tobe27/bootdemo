package com.example.boot.rest.service.impl;

import com.example.boot.exception.UserException;
import com.example.boot.rest.dao.UserDOMapper;
import com.example.boot.rest.model.UserDO;
import com.example.boot.rest.service.UserDOService;
import com.github.pagehelper.PageHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Created by L.C.Y on 2018-11-22
 */
@Service
public class UserDOServiceImpl implements UserDOService {
    private final UserDOMapper userDOMapper;

    @Autowired
    public UserDOServiceImpl(UserDOMapper userDOMapper) {
        this.userDOMapper = userDOMapper;
    }

    private static Logger logger = LoggerFactory.getLogger(UserDOServiceImpl.class);

    /**
     * 删除用户
     *
     * @param id 用户编号
     * @return boolean
     * @throws Exception 数据库异常
     */
    @Override
    public boolean deleteByPrimaryKey(Long id) throws Exception {
        try {
            return userDOMapper.deleteByPrimaryKey(id) == 1;
        } catch (Exception e) {
            logger.info("删除用户异常：" + e.getMessage());
            throw new UserException("删除用户异常");
        }
    }

    /**
     * 新建用户
     *
     * @param record 用户
     * @return boolean
     * @throws Exception 数据库异常
     */
    @Override
    public boolean insertSelective(UserDO record) throws Exception {
        // 创建时间
        long now = System.currentTimeMillis();
        record.setCreatedAt(now);
        record.setUpdatedAt(now);
        try {
            return userDOMapper.insertSelective(record) == 1;
        } catch (Exception e) {
            logger.info("新建用户异常：" + e.getMessage());
            throw new UserException("新建用户异常");
        }
    }

    /**
     * 查询用户
     *
     * @param id 用户编号
     * @return 用户
     * @throws Exception 数据库异常
     */
    @Override
    public UserDO getUserDO(Long id) throws Exception {
        try {
            return userDOMapper.getUserDO(id);
        } catch (Exception e) {
            logger.info("查询用户异常：" + e.getMessage());
            throw new UserException("查询用户异常");
        }
    }

    /**
     * 查询列表
     * @param userDO 用户
     * @param pageNum 页码
     * @param pageSize 页行数
     * @return 用户列表
     * @throws Exception 数据库异常
     */
    @Override
    public List<UserDO> listUserDOs(UserDO userDO, Integer pageNum, Integer pageSize) throws Exception {
        if (pageNum == null || pageSize == null) {
            throw new UserException("页码和页行数不能为空");
        }
        PageHelper.startPage(pageNum, pageSize);
        try {
            return userDOMapper.listUserDOs(userDO);
        } catch (Exception e) {
            logger.info("查询用户列表异常：" + e.getMessage());
            throw new UserException("查询用户列表异常");
        }
    }

    /**
     * 编辑用户
     *
     * @param record 用户
     * @return boolean
     * @throws Exception 数据库异常
     */
    @Override
    public boolean updateByPrimaryKeySelective(UserDO record) throws Exception {
        // 修改时间
        long now = System.currentTimeMillis();
        record.setUpdatedAt(now);
        try {
            return userDOMapper.updateByPrimaryKeySelective(record) == 1;
        } catch (Exception e) {
            logger.info("编辑用户异常：" + e.getMessage());
            throw new UserException("编辑用户异常");
        }
    }
}

package com.example.boot.rest.service;

import com.example.boot.rest.model.UserDO;

import java.util.List;

/**
 * @author Created by L.C.Y on 2018-11-22
 */
public interface UserDOService {
    /**
     * 删除用户
     * @param id 用户编号
     * @return boolean
     * @throws Exception 数据库异常
     */
    boolean deleteByPrimaryKey(Long id) throws Exception;

    /**
     * 新建用户
     * @param record 用户
     * @return boolean
     * @throws Exception 数据库异常
     */
    boolean insertSelective(UserDO record) throws Exception;

    /**
     * 查询用户
     * @param id 用户编号
     * @return 用户
     * @throws Exception 数据库异常
     */
    UserDO getUserDO(Long id) throws Exception;

    /**
     * 查询列表
     * @param userDO 用户
     * @param pageNum 页码
     * @param pageSize 页行数
     * @return 用户列表
     * @throws Exception 数据库异常
     */
    List<UserDO> listUserDOs(UserDO userDO, Integer pageNum, Integer pageSize) throws Exception;

    /**
     * 编辑用户
     * @param record 用户
     * @return boolean
     * @throws Exception 数据库异常
     */
    boolean updateByPrimaryKeySelective(UserDO record) throws Exception;
}

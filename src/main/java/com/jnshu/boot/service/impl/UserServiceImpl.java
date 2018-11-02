package com.jnshu.boot.service.impl;

import com.jnshu.boot.dao.UserMapper;
import com.jnshu.boot.model.User;
import com.jnshu.boot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final
    UserMapper userMapper;

    @Autowired
    public UserServiceImpl(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    public User findById(String id) {
        return userMapper.findById(id);
    }

    @Override
    public void modifyName(String id, String name) {
        userMapper.modifyName(id,name);
    }

    @Override
    public void delete(String id) {
        userMapper.delete(id);

    }

    @Override
    public void addUser(User user) {
        userMapper.addUser(user);
    }
}

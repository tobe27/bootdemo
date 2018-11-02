package com.example.boot.rest.service.impl;

import com.example.boot.rest.service.UserService;
import com.example.boot.rest.dao.UserMapper;
import com.example.boot.rest.model.User;
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

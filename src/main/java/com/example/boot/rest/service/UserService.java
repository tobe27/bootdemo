package com.example.boot.rest.service;

import com.example.boot.rest.model.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserService {
    User findById(String id);
    List<User> list();
    boolean modifyName(User user);
    boolean delete(String id);
    boolean addUser(User user);
}

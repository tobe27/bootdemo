package com.example.boot.rest.service;

import com.example.boot.rest.model.User;
import org.apache.ibatis.annotations.Param;

public interface UserService {
    User findById(@Param("id") String id);
    void modifyName(@Param("id") String id,@Param("name") String name );
    void delete(@Param("id") String id);
    void addUser(User user);
}

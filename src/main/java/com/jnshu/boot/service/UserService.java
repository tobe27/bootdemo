package com.jnshu.boot.service;

import com.jnshu.boot.model.User;
import org.apache.ibatis.annotations.Param;

public interface UserService {
    User findById(@Param("id") String id);
    void modifyName(@Param("id") String id,@Param("name") String name );
    void delete(@Param("id") String id);
    void addUser(User user);
}

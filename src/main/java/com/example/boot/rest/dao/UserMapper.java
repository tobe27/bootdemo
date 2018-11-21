package com.example.boot.rest.dao;

import com.example.boot.rest.model.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

@Mapper
@Repository
public interface UserMapper {

    @Select("select * from user where id = #{id}")
    User findById(String id);

    @Select("select * from user")
    List<User> list();

    @Update("update user set name = #{name} where id = #{id}")
    int modifyName(User user);

    @Delete("delete from user where id = #{id}")
    int delete(String id);

    @Insert("insert into user(name,password) values(#{name},#{password})")
    int addUser(User user);
}

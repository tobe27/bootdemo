package com.example.boot.rest.dao;

import com.example.boot.rest.model.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface UserMapper {

    @Select("select * from user where id = #{id}")
    User findById(@Param("id") String id);

    @Update("update user set name = #{name} where id = #{id}")
    void modifyName(@Param("id") String id,@Param("name") String name );

    @Delete("delete from user where id = #{id}")
    void delete(@Param("id") String id);

    @Insert("insert into user(name,password) values(#{name},#{password})")
    void addUser(User user);
}

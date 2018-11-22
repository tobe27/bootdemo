package com.example.boot.rest.dao;

import com.example.boot.rest.model.UserDO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface UserDOMapper {
    int deleteByPrimaryKey(Long id);

    int insertSelective(UserDO record);

    UserDO getUserDO(Long id);

    List<UserDO> listUserDOs(UserDO userDO);

    int updateByPrimaryKeySelective(UserDO record);
}
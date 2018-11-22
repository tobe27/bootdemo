package com.example.boot.rest.service;

import com.alibaba.fastjson.JSON;
import com.example.boot.rest.model.UserDO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserDOServiceTest {
    @Autowired
    UserDOService userDOService;

    @Test
    public void insert() throws Exception {
        UserDO userDO = new UserDO();
        userDO.setName("张无忌")
                .setPassword("123456")
                .setGender("男");
        System.out.println(userDOService.insertSelective(userDO));
        // 新建后立即返回ID
        System.out.println(userDO.getId());
    }

    @Test
    public void update() throws Exception {
        UserDO userDO = new UserDO();
        userDO.setId(1L)
                .setName("张无忌")
                .setPassword("123456")
                .setGender("男");
        System.out.println(userDOService.updateByPrimaryKeySelective(userDO));
    }

    @Test
    public void select() throws Exception {
        System.out.println(userDOService.getUserDO(1L));
        //System.out.println(JSON.toJSONString(userDOService.listUserDOs(), true));
    }

    @Test
    public void delete() throws Exception {
        System.out.println(userDOService.deleteByPrimaryKey(3L));
    }

}
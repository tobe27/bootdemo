package com.example.boot.rest.controller;

import com.example.boot.rest.model.ResultBean;
import com.example.boot.rest.service.UserService;
import com.example.boot.rest.model.User;
import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "/user/{id}",method = RequestMethod.GET)
    public ResultBean findById(@PathVariable String id){
        return new ResultBean().success(userService.findById(id));
    }

    @RequestMapping(value = "/user/list", method = RequestMethod.GET)
    public ResultBean list(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<User> userList = userService.list();
        PageInfo<User> pageInfo = new PageInfo<>(userList);
        return new ResultBean().success(pageInfo.getTotal(), pageInfo.getList());
    }

    @RequestMapping(value = "/user",method = RequestMethod.POST)
    public ResultBean insertUser(@RequestBody User user){ //接收对象要使用@ModelAttribute注解
        userService.addUser(user);
        return new ResultBean().success();
    }

    @RequestMapping(value = "/user/{id}",method = RequestMethod.PUT)
    public ResultBean updateUser(@RequestBody User user){
        userService.modifyName(user);
        return new ResultBean().success();
    }

    @RequestMapping(value = "/user/{id}",method = RequestMethod.DELETE)
    public ResultBean deleteById(@PathVariable String id){
        userService.delete(id);
        return new ResultBean().success();
    }

}

package com.jnshu.boot.controller;

import com.jnshu.boot.model.User;
import com.alibaba.fastjson.JSON;
import com.jnshu.boot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "/user/{id}",method = RequestMethod.GET)
    public String findById(@PathVariable String id){
        return JSON.toJSONString(userService.findById(id),true);
    }

    @RequestMapping(value = "/user",method = RequestMethod.POST)
    public String insertUser(@ModelAttribute User user){ //接收对象要使用@ModelAttribute注解
        userService.addUser(user);
        return "user="+user+"添加成功";
    }

    @RequestMapping(value = "/user/{id}",method = RequestMethod.PUT)
    public String updateUser(@PathVariable String id,@RequestParam String name){
        userService.modifyName(id,name);
        return "user{name:"+name+"}";
    }

    @RequestMapping(value = "/user/{id}",method = RequestMethod.DELETE)
    public String deleteById(@PathVariable String id){
        userService.delete(id);
        return "id="+id+":删除成功";
    }

}

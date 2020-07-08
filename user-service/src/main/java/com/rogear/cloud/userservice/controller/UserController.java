package com.rogear.cloud.userservice.controller;

import com.rogear.cloud.userservice.pojo.CommonResult;
import com.rogear.cloud.userservice.pojo.User;
import com.rogear.cloud.userservice.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Rogear on 2020/7/8
 **/
@Controller
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @ResponseBody
    @RequestMapping(value = "/{id}",produces = {"application/json;charset=UTF-8"})
    public CommonResult getUserById(@PathVariable Long id){
        User user = userService.getUserById(id);
        if (user != null){
            return new CommonResult(user);
        } else {
            return new CommonResult(200,"没有找到符合条件的用户信息",null);
        }
    }

    @ResponseBody
    @RequestMapping(value = "/getUserByName",produces = {"application/json;charset=UTF-8"})
    public CommonResult getUserByName(@RequestParam String username){
        List<User> users = userService.getUserByName(username);
        if (users != null && users.size() > 0){
            return new CommonResult(users);
        } else {
            return new CommonResult(200,"没有找到符合条件的用户信息",null);
        }
    }
}

package com.rogear.cloud.openfeignservice.controller;

import com.rogear.cloud.openfeignservice.pojo.CommonResult;
import com.rogear.cloud.openfeignservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Rogear on 2020/7/9
 **/
@Controller
@RequestMapping("/user")
public class UserOpenFeignController {

    private final UserService userService;

    public UserOpenFeignController(UserService userService) {
        this.userService = userService;
    }

    @ResponseBody
    @RequestMapping(value = "/{id}",produces = "application/json;charset=UTF-8")
    public CommonResult getUserById(@PathVariable Long id){
        return userService.getUserById(id);
    }
}

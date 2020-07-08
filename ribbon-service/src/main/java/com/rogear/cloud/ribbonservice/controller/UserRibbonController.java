package com.rogear.cloud.ribbonservice.controller;

import com.rogear.cloud.ribbonservice.pojo.CommonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

/**
 * Created by Rogear on 2020/7/8
 **/
@Controller
@RequestMapping("/user")
public class UserRibbonController {

    private final RestTemplate restTemplate;

    @Value("${service-url.user-service}")
    private String USER_SERVICE_URL;

    public UserRibbonController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @ResponseBody
    @RequestMapping(value = "/{id}",produces = {"application/json;charset=UTF-8"})
    public CommonResult getUserById(@PathVariable Long id){
        CommonResult result = restTemplate.getForObject(USER_SERVICE_URL + "/user/" + id, CommonResult.class);
        if (result != null){
            return result;
        } else {
            return new CommonResult(500,"user-service服务调用异常",null);
        }
    }

    @ResponseBody
    @RequestMapping(value = "/getUserByName",produces = {"application/json;charset=UTF-8"})
    public CommonResult getUserByName(@RequestParam String username){
        CommonResult result = restTemplate.getForObject(USER_SERVICE_URL + "/getUserByName", CommonResult.class, username);
        if (result != null){
            return result;
        } else {
            return new CommonResult(500,"user-service服务调用异常",null);
        }
    }
}

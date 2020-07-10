package com.rogear.cloud.hystrixservice.service.impl;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.rogear.cloud.hystrixservice.pojo.CommonResult;
import com.rogear.cloud.hystrixservice.pojo.User;
import com.rogear.cloud.hystrixservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * Created by Rogear on 2020/7/9
 **/
@Service
public class UserServiceImpl implements UserService {

    @Value("${service-url.user-service}")
    private String USER_SERVICE_URL;

    private final RestTemplate restTemplate;

    public UserServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    @HystrixCommand(fallbackMethod = "getUserError")
    public CommonResult getUserById(Long id) {
        CommonResult result = restTemplate.getForObject(USER_SERVICE_URL + "/user/{1}", CommonResult.class, id);
        return result;
    }

    public CommonResult getUserError(Long id){
        return new CommonResult(500,"服务异常，请稍后再试！",null);
    }
}

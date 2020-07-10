package com.rogear.cloud.openfeignservice.service;

import com.rogear.cloud.openfeignservice.pojo.CommonResult;
import com.rogear.cloud.openfeignservice.service.impl.UserFallbackServiceImpl;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Rogear on 2020/7/9
 **/
@FeignClient(value = "user-service",fallback = UserFallbackServiceImpl.class)
public interface UserService {

    @ResponseBody
    @RequestMapping(value = "user/{id}",produces = {"application/json;charset=UTF-8"})
    CommonResult getUserById(@PathVariable Long id);
}

package com.rogear.cloud.openfeignservice.service.impl;

import com.rogear.cloud.openfeignservice.pojo.CommonResult;
import com.rogear.cloud.openfeignservice.service.UserService;
import org.springframework.stereotype.Service;

/**
 * Created by Rogear on 2020/7/9
 **/
@Service
public class UserFallbackServiceImpl implements UserService {
    @Override
    public CommonResult getUserById(Long id) {
        return new CommonResult(500,"服务调用失败，服务被降级",null);
    }
}

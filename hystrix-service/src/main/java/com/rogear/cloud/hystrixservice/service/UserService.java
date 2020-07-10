package com.rogear.cloud.hystrixservice.service;

import com.rogear.cloud.hystrixservice.pojo.CommonResult;
import com.rogear.cloud.hystrixservice.pojo.User;

/**
 * Created by Rogear on 2020/7/9
 **/
public interface UserService {
    CommonResult getUserById(Long id);
}

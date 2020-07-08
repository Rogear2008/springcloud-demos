package com.rogear.cloud.userservice.service;

import com.rogear.cloud.userservice.pojo.User;

import java.util.List;

/**
 * Created by Rogear on 2020/7/8
 **/
public interface UserService {
    User getUserById(Long id);
    List<User> getUserByName(String username);
}

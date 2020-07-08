package com.rogear.cloud.userservice.service.impl;

import com.rogear.cloud.userservice.pojo.User;
import com.rogear.cloud.userservice.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Rogear on 2020/7/8
 **/
@Service
public class UserServiceImpl implements UserService {

    private List<User> users = new ArrayList<>();

    @PostConstruct
    private void init(){
        users.add(new User(1L,"擎天柱","123"));
        users.add(new User(2L,"大黄蜂","123"));
        users.add(new User(3L,"霸天虎","123"));
    }

    @Override
    public User getUserById(Long id) {
        List<User> list = users.stream().filter(user -> user.getId() == id).collect(Collectors.toList());
        return list.get(0);
    }

    @Override
    public List<User> getUserByName(String username) {
        List<User> list = users.stream().filter(user -> username.contains(username)).collect(Collectors.toList());
        return list;
    }
}

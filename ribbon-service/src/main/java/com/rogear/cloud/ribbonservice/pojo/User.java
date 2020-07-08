package com.rogear.cloud.ribbonservice.pojo;

import java.io.Serializable;

/**
 * 用户类
 * Created by Rogear on 2020/7/8
 **/
public class User implements Serializable {
    private static final long serialVersionUID = 5982603133780318802L;
    private Long id;
    private String username;
    private String password;

    public User(){

    }

    public User(Long id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

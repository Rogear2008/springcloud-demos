package com.rogear.cloud.ribbonservice.pojo;

import java.io.Serializable;

/**
 * 一般返回对象
 * Created by Rogear on 2020/7/8
 **/
public class CommonResult<T> implements Serializable {
    private static final long serialVersionUID = -1082980142811730082L;
    private Integer status;
    private String message;
    private T data;

    public CommonResult() {
    }

    public CommonResult(int status, String message, T data){
        this.status = status;
        this.message = message;
        this.data = data;
    }

    public CommonResult(Integer status,String message){
        this.status = status;
        this.message = message;
    }

    public CommonResult(T data){
        this.status = 200;
        this.message = "操作成功";
        this.data = data;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}

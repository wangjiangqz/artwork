package com.work.artwork.common.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class Result<T> implements Serializable{

    private Boolean isSuccess = true;

    private T data;

    private String errorMsg;

    public Result(){}

    public Result(Boolean isSuccess,String errorMsg){
        this.isSuccess = isSuccess;
        this.errorMsg = errorMsg;
    }

    public Result(T data){
        this.data = data;
    }

}

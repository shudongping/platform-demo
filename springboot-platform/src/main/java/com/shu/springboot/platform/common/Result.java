package com.shu.springboot.platform.common;

import com.sun.org.apache.regexp.internal.RE;
import lombok.Data;

/**
 * Created by shudongping on 2018/3/21 0021.
 */
@Data
public class Result<T> {

    private String message;

    private int code;

    private T data;

    public Result(T data){
        this.data = data;
    }


    public static <T> Result<T> success(T data){
        return new Result<T>(data);
    }



}

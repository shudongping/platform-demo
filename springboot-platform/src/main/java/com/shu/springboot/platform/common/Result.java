package com.shu.springboot.platform.common;

import lombok.Data;

/**
 * Created by shudongping on 2018/3/21 0021.
 */
@Data
public class Result<T> {

    private String message;

    private int code;

    private T data;

    private Result(T data){
        this.data = data;
    }


    public static <T> Result<T> success(T data){
        return new Result<T>(data);
    }

    /**
     *  失败时候的调用
     * */
    public static  <T> Result<T> error(CodeMessage codeMsg){
        return new Result<T>(codeMsg);
    }

    private Result(CodeMessage codeMsg) {
        if(codeMsg != null) {
            this.code = codeMsg.getCode();
            this.message = codeMsg.getMsg();
        }
    }

}

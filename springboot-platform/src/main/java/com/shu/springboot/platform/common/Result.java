package com.shu.springboot.platform.common;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * @author shudongping
 * @date 2018/03/21
 */
@Data
public class Result<T> {

    private String message;

    private int code = 200;

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


    //生成随机数字和字母,
    public static String getStringRandom(int length) {
        String val = "";
        Random random = new Random();
        //参数length，表示生成几位随机数
        for(int i = 0; i < length; i++) {
                val += (char)(random.nextInt(26) + 97);
        }
        return val;
    }

    public static void  main(String[] args) {
        String test = getStringRandom(6);
        //测试
        System.out.println(test);
    }

}

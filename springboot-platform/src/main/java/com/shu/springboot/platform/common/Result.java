package com.shu.springboot.platform.common;

import com.google.common.collect.Lists;
import lombok.Data;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.commons.lang3.time.DateUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author shudongping
 * @date 2018/03/21
 */
@Data
public class Result<T> {

    private String message;

    private int code = 200;

    private T data;

    private Result(T data) {
        this.data = data;
    }


    public static <T> Result<T> success(T data) {
        return new Result<T>(data);
    }

    /**
     * 失败时候的调用
     */
    public static <T> Result<T> error(CodeMessage codeMsg) {
        return new Result<T>(codeMsg);
    }

    private Result(CodeMessage codeMsg) {
        if (codeMsg != null) {
            this.code = codeMsg.getCode();
            this.message = codeMsg.getMsg();
        }
    }

    public static void main(String args[]) {

    }


}

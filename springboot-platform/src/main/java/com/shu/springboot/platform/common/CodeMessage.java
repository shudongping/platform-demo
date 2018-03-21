package com.shu.springboot.platform.common;

import lombok.Data;

/**
 * @author shudongping
 * @date 2018/03/21
 */
@Data
public class CodeMessage {

    private int code;

    private String msg;

    public static CodeMessage USER_ERROR = new CodeMessage(101, "用户错误");

    public static CodeMessage SERVER_ERROR = new CodeMessage(500, "服务器错误");

    public CodeMessage() {
    }

    public CodeMessage(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}

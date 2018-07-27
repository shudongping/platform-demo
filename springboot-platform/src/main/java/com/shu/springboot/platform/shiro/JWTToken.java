package com.shu.springboot.platform.shiro;

import org.apache.shiro.authc.AuthenticationToken;

/**
 * @author shudongping
 * @date 2018/07/26
 */
public class JWTToken implements AuthenticationToken {


    private String token;

    public JWTToken(String token) {
        this.token = token;
    }

    @Override
    public Object getPrincipal() {
        return token;
    }

    @Override
    public Object getCredentials() {
        return token;
    }
}

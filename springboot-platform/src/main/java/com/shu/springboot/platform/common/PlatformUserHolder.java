package com.shu.springboot.platform.common;

import com.shu.springboot.platform.domain.pojo.PlatformUser;

/**
 * @author shudongping
 * @date 2018/07/17
 */
public class PlatformUserHolder {

    private static final ThreadLocal<PlatformUser> userHolder = new ThreadLocal<PlatformUser>();

    public static void add(PlatformUser user) {
        userHolder.set(user);
    }

    public static PlatformUser getUser() {
        return userHolder.get();
    }

    public static void remove(){
        userHolder.remove();
    }


}

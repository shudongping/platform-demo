package com.shu.springboot.platform.event;

import com.shu.springboot.platform.domain.pojo.PlatformUser;
import org.springframework.context.ApplicationEvent;

/**
 * @author shudongping
 * @date 2018/07/17
 */
public class DemoEvent extends ApplicationEvent {

    private PlatformUser user;

    public PlatformUser getUser() {
        return user;
    }

    public void setUser(PlatformUser user) {
        this.user = user;
    }

    public DemoEvent(Object source,PlatformUser user) {
        super(source);
        this.user = user;
    }
}

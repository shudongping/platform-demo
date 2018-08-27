package com.shu.springboot.platform.event;

import com.shu.springboot.platform.domain.pojo.PlatformUser;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

/**
 * @author shudongping
 * @date 2018/07/17
 */
@Slf4j
@Component
public class DemoListener implements ApplicationListener<DemoEvent> {

    @Override
    @Async
    public void onApplicationEvent(DemoEvent demoEvent) {
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        PlatformUser user = demoEvent.getUser();
        log.info("user姓名：{}",user.getUsername());
    }
}

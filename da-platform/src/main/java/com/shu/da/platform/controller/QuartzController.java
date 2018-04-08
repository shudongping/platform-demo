package com.shu.da.platform.controller;

import com.shu.da.platform.quartz.QuartzManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author shudongping
 * @date 2018/04/08
 */
@RestController
@RequestMapping("/quartz")
public class QuartzController {


    @Autowired
    private QuartzManager quartzManager;


    /**
     * 添加定时任务
     * @return
     * @throws Exception
     */
    @PostMapping("/quartz")
    public Object addJob() throws Exception{
        quartzManager.addJob("test","testGroup", "com.shu.da.platform.quartz.QuartzJob","*/1 * * * * ?");

        quartzManager.addJob("myTest","myTest", "com.shu.da.platform.quartz.QuartzJob","*/1 * * * * ?");

        return "success";
    }

    /**
     * 暂停一个定时任务
     * @return
     * @throws Exception
     */
    @PutMapping("/stop")
    public Object stopJob() throws Exception{
        quartzManager.stopJob("test","testGroup");
        return "success";
    }

    /**
     * 启动一个定时任务
     * @return
     * @throws Exception
     */
    @PutMapping("/start")
    public Object startJob() throws Exception{
        quartzManager.startJob("test","testGroup");
        return "success";
    }

    @PutMapping("/modify")
    public Object modifyJob() throws Exception{
        quartzManager.modifyJob("test","testGroup","*/1 * * * * ?");
        return "success";
    }

}

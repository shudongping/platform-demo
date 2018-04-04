package com.shu.da.platform.controller;

import com.shu.da.platform.kettle.JobManager;
import com.shu.da.platform.kettle.KettleUtils;
import lombok.extern.slf4j.Slf4j;
import org.pentaho.di.core.logging.KettleLogStore;
import org.pentaho.di.core.logging.LoggingBuffer;
import org.pentaho.di.job.Job;
import org.pentaho.di.job.JobMeta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author shudongping
 * @date 2018/04/03
 */
@RestController
@RequestMapping("/test")
@Slf4j
public class TestController {




    /**
     * 从数据库资源库获取job
     *
     * @param jobId
     * @return
     * @throws Exception
     */
    @GetMapping("/job/{jobId}")
    public Object getJob(@PathVariable("jobId") Long jobId) throws Exception {

        JobMeta jobMeta = KettleUtils.loadJob(jobId);

        log.info(jobMeta.toString());

        Job job = new Job(KettleUtils.getInstanceRep(), jobMeta);

//        Thread.sleep(1000*5);

//        job.start();
//        job.run();
//        Thread.sleep(1000*5);
//        String all_msg = KettleLogStore.getAppender().getBuffer().toString();
//        String logChannelId = job.getLogChannelId();
//        LoggingBuffer appender = KettleLogStore.getAppender();
//        String logText = appender.getBuffer(logChannelId, true).toString();

        String status = JobManager.startJob(job);
        return status;
    }

    /**
     * 实时日志
     * @return
     * @throws Exception
     */
    @GetMapping("/job/{jobId}/log")
    public Object getLog(@PathVariable("jobId") Long jobId) throws Exception{
        JobMeta jobMeta = KettleUtils.loadJob(jobId);

        Job job = new Job(KettleUtils.getInstanceRep(), jobMeta);
        String all_msg = KettleLogStore.getAppender().getBuffer().toString();
        log.info(all_msg);
        String logChannelId = job.getLogChannelId();
        LoggingBuffer appender = KettleLogStore.getAppender();
        String logText = appender.getBuffer(logChannelId, true).toString();
        log.info(logChannelId+":"+logText);
        return all_msg;
    }

    @GetMapping("/log")
    public Object getTest() throws Exception{
        return "log success";
    }



}

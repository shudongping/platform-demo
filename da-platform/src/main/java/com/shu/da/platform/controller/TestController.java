package com.shu.da.platform.controller;

import com.alibaba.fastjson.JSONObject;
import com.shu.da.platform.kettle.JobManager;
import com.shu.da.platform.kettle.KettleUtils;
import com.shu.da.platform.quartz.QuartzManager;
import lombok.extern.slf4j.Slf4j;
import org.pentaho.di.job.JobMeta;
import org.pentaho.di.trans.Trans;
import org.pentaho.di.trans.TransMeta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author shudongping
 * @date 2018/04/03
 */
@RestController
@RequestMapping("/test")
@Slf4j
public class TestController {

    @Autowired
    private JobManager jobManager;



    /**
     * 从数据库资源库获取job  执行job
     *
     * @param jobId
     * @return
     * @throws Exception
     */
    @GetMapping("/job/{jobId}")
    public Object getJob(@PathVariable("jobId") Long jobId) throws Exception {

        JobMeta jobMeta = KettleUtils.loadJob(jobId);

        String status = jobManager.startJob(jobId);

        return status;
    }

    /**
     * 将ktr文件 保存进数据库
     * @return
     * @throws Exception
     */
    @GetMapping("/ktr")
    public Object convertKtrToRes() throws Exception{

        TransMeta transMeta = new TransMeta("D:/其他/ktrTest.ktr");

        jobManager.ktrToRes(transMeta);

        return "success";
    }

    @GetMapping("/trans/{transId}")
    public Object startTrans(@PathVariable("transId") Long transId) throws Exception{
            TransMeta transMeta = KettleUtils.loadTransMeta(transId);
            return "";
    }



    /**
     * 停止job
     * @param jobId
     * @return
     * @throws Exception
     */
    @PutMapping("/job/{jobId}")
    public Object stopJob(@PathVariable("jobId") Long jobId) throws Exception{
        return jobManager.stopJob(jobId);
    }

    /**
     * 删除job
     * @param jobId
     * @return
     * @throws Exception
     */
    @DeleteMapping("/job/{jobId}")
    public Object removeJob(@PathVariable("jobId") Long jobId) throws Exception{
        return jobManager.deleteJob(jobId);
    }


    /**
     * 实时日志
     * @return
     * @throws Exception
     */
    @GetMapping("/job/{jobId}/log")
    public Object getLog(@PathVariable("jobId") Long jobId) throws Exception{
//        JobMeta jobMeta = KettleUtils.loadJob(jobId);
//        Job job = new Job(KettleUtils.getInstanceRep(), jobMeta);
//        String all_msg = KettleLogStore.getAppender().getBuffer().toString();
//        log.info(all_msg);
//        String logChannelId = job.getLogChannelId();
//        LoggingBuffer appender = KettleLogStore.getAppender();
//        String logText = appender.getBuffer(logChannelId, true).toString();
//        log.info(logChannelId+":"+logText);
        return jobManager.getJobLog(jobId);
    }

    @GetMapping("/log")
    public Object getTest() throws Exception{
        return "log success";
    }





}

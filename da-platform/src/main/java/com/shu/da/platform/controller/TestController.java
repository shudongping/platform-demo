package com.shu.da.platform.controller;

import com.shu.da.platform.kettle.KettleUtils;
import lombok.extern.slf4j.Slf4j;
import org.pentaho.di.job.Job;
import org.pentaho.di.job.JobMeta;
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

        job.start();

        return job.getObjectId();
    }

}

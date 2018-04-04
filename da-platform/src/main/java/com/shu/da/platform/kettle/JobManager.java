package com.shu.da.platform.kettle;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.pentaho.di.job.Job;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileOutputStream;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

/**
 * @author shudongping
 * @date 2018/04/04
 */
@Service
@Slf4j
public class JobManager {

    /**
     * <作业id,作业>
     */
    private static Map<String, Job> jobMap = new Hashtable<String, Job>();
    /**
     * <作业,JSON作业>
     */
    private static Map<Job, JSONObject> jsonjobMap = new Hashtable<Job, JSONObject>();
    /**
     * <作业,开始时间>
     */
    private static Map<Job, String> jobStartDateMap = new Hashtable<Job, String>();
    /**
     * <作业,日志主键>
     */
    private static Map<Job, String> jobLogOidMap = new Hashtable<Job, String>();
    /**
     * <作业，已处理行数>
     */
    private static Map<Job, Integer> jobLogLine = new HashMap<Job, Integer>();
    /**
     * <作业，作业对应的日志文件>
     */
    private static Map<Job, File> jobLogFile = new HashMap<Job, File>();
    /**
     * <作业，作业对应的日志输出流>
     */
    private static Map<Job, FileOutputStream> jobLogStream = new HashMap<Job, FileOutputStream>();


    public static String startJob(Job job) {
        System.out.println(JobManager.class.getClassLoader());
        String rs = getJobRunStatus(job.getObjectId().getId());
        if (rs != null) {
            return rs;
        }
        job.start();
        jobMap.put(job.getObjectId().getId(), job);
        jobLogLine.put(job, 0);
        jobLogStream.put(job, null);
        log.info("作业启动完成：" + job.getJobname());
        String status = getJobStatus(job);
        return status;
    }

    public static String getJobRunStatus(String jobId) {
        if (jobMap.containsKey(jobId)) {
            //获取已经存在的job
            Job job = jobMap.get(jobId);
            //正在运行的
            if (job.isActive()) {
                return job.getStatus();
            } else {
                log.info("getJobRunStatus:" + "这里在运行，写入日志");
                jobLogLine.remove(job);
                jobLogStream.remove(job);
                synchronized (jobMap) {
                    jobMap.remove(jobId);
                }
            }
        }
        return null;
    }

    public static String getJobStatus(Job job) {
        String status = job.getStatus();
        if (status.indexOf("errors") > -1) {
            status = "fail";
        }
        return status;
    }


}

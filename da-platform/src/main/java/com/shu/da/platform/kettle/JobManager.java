package com.shu.da.platform.kettle;

import lombok.extern.slf4j.Slf4j;
import org.pentaho.di.core.logging.KettleLogStore;
import org.pentaho.di.core.logging.LoggingBuffer;
import org.pentaho.di.job.Job;
import org.pentaho.di.job.JobMeta;
import org.pentaho.di.repository.LongObjectId;
import org.pentaho.di.repository.ObjectId;
import org.pentaho.di.repository.RepositoryDirectory;
import org.pentaho.di.trans.Trans;
import org.pentaho.di.trans.TransMeta;
import org.springframework.stereotype.Service;

import java.util.Hashtable;
import java.util.Map;

/**
 * @author shudongping
 * @date 2018/04/04
 */
@Service
@Slf4j
public class JobManager {


    private static Map<String,Job> jobMap = new Hashtable<String,Job>();

    public Object ktrToRes(TransMeta transMeta) throws Exception{
        transMeta.getRepositoryDirectory().setObjectId(new LongObjectId(0));
        KettleUtils.saveTrans(transMeta);

        return "success";
    }


    public Object excuteTrans(TransMeta transMeta) throws Exception{
        Trans trans = new Trans(transMeta);
        trans.execute(null);
        return "success";
    }


    public String startJob(Long jobId) throws Exception{

        JobMeta jobMeta = KettleUtils.loadJob(jobId);

        Job job = new Job(KettleUtils.getInstanceRep(), jobMeta);

        String rs = checkJobStatus(String.valueOf(jobId));
        if(rs != null){
            return job.getStatus();
        }

        job.start();

        jobMap.put(job.getObjectId().getId(),job);

        return job.getStatus();

    }

    private String checkJobStatus(String jobId) throws Exception{
        if(jobMap.containsKey(jobId)){
            Job job = jobMap.get(jobId);
            if(job.isActive()){
                return job.getStatus();
            }else {
                synchronized (jobMap) {
                    jobMap.remove(jobId);
                }

            }
        }
        return null;
    }

    public String stopJob(Long jobId) throws Exception{

        Job job = jobMap.get(String.valueOf(jobId));

        if(job == null){
            return Trans.STRING_STOPPED;
        }
        job.stopAll();

        return job.getStatus();

    }

    public String deleteJob(Long jobId) throws Exception{

        KettleUtils.delJob(jobId);

        return "success";

    }



    public Object getJobLog(Long jobId) throws Exception{

        Job job = jobMap.get(String.valueOf(jobId));
        if(job == null){
            return "no log";
        }
        String logChannelId = job.getLogChannelId();
        LoggingBuffer appender = KettleLogStore.getAppender();
        String logText = appender.getBuffer(logChannelId, true).toString();

        return logText;

    }





}

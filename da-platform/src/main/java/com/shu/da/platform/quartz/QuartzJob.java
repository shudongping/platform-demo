package com.shu.da.platform.quartz;

import lombok.extern.slf4j.Slf4j;
import org.quartz.*;

/**
 * @author shudongping
 * @date 2018/04/08
 */
@Slf4j
@PersistJobDataAfterExecution
public class QuartzJob implements Job {

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {

        CronTrigger trigger = (CronTrigger) jobExecutionContext.getTrigger();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        log.info(trigger.getKey().getName()+":正在执行定时调度任务");


    }
}

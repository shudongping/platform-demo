package com.shu.da.platform.quartz;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
import org.springframework.stereotype.Service;

/**
 * @author shudongping
 * @date 2018/04/08
 */
@Service
public class QuartzManager {

    private SchedulerFactory schedulerFactory = new StdSchedulerFactory();

    public void addJob(String jobName, String groupName, String className, String cron) throws Exception {

        Scheduler scheduler = schedulerFactory.getScheduler();

        Class clazz = Class.forName(className);

        JobDetail jobDetail = JobBuilder.newJob(clazz).withIdentity(jobName, groupName).build();

        TriggerBuilder<Trigger> triggerBuilder = TriggerBuilder.newTrigger();
        triggerBuilder.withIdentity(jobName, groupName);
        triggerBuilder.startNow();
        triggerBuilder.withSchedule(CronScheduleBuilder.cronSchedule(cron));
        CronTrigger trigger = (CronTrigger) triggerBuilder.build();

        scheduler.scheduleJob(jobDetail, trigger);
        // 启动
        if (!scheduler.isShutdown()) {
            scheduler.start();
        }


    }


    public void stopJob(String jobName, String groupName) throws Exception {

        Scheduler scheduler = schedulerFactory.getScheduler();

        JobKey jobKey = JobKey.jobKey(jobName, groupName);

        scheduler.pauseJob(jobKey);
    }

    public void startJob(String jobName, String groupName) throws Exception {
        Scheduler scheduler = schedulerFactory.getScheduler();

        JobKey jobKey = JobKey.jobKey(jobName, groupName);

        scheduler.resumeJob(jobKey);
    }

    public void modifyJob(String jobName, String groupName, String cron) throws Exception {
        Scheduler scheduler = schedulerFactory.getScheduler();
        TriggerKey triggerKey = TriggerKey.triggerKey(jobName, groupName);

        CronTrigger trigger = (CronTrigger) scheduler.getTrigger(triggerKey);

        trigger = trigger.getTriggerBuilder().withIdentity(triggerKey).withSchedule(CronScheduleBuilder.cronSchedule(cron)).build();

        scheduler.rescheduleJob(triggerKey, trigger);

    }

}

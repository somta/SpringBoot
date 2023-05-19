package net.somta.springboot.scheduled.core;

import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Description:
 * @Author: Rachel
 * @DateTime: 2022/8/21 17:22
 */
public abstract class AbstractSchedulingConfigurer implements SchedulingConfigurer {

    @Resource
    protected List<AbstractScheduling> abstractSchedulingList;

    /**
     * 获取线程池
     * @return 线程池
     */
    protected abstract TaskScheduler getTaskScheduler();

    protected List<AbstractScheduling> getTaskList(){
        return this.abstractSchedulingList;
    }

    @Override
    public void configureTasks(ScheduledTaskRegistrar scheduledTaskRegistrar) {
        System.out.println("[AbstractSchedulingConfigurer.configureTasks] 定时任务执行器 start");
        scheduledTaskRegistrar.setScheduler(getTaskScheduler());
        if(CollectionUtils.isEmpty(getTaskList())){
            System.out.println("待执行的定时任务为空");
        }
        getTaskList().forEach(scheduling ->
            scheduledTaskRegistrar.addTriggerTask(
                    scheduling::execute,
                    triggerContext -> new CronTrigger(scheduling.getScheduledTask().getCron()).nextExecutionTime(triggerContext)));
    }
}


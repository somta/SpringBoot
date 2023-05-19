package net.somta.springboot.scheduled.service;

import net.somta.springboot.scheduled.model.ScheduledTask;
import org.springframework.stereotype.Service;

/**
 * TODO 类职责描述
 *
 * @author husong
 * @date 2023/05/18
 */
@Service
public class SystemScheduledService {


    /**
     * 查询一个ScheduledTask,实际可以从数据库查
     * @return
     */
    public ScheduledTask queryScheduledTask() {
        ScheduledTask scheduledTask = new ScheduledTask();
        scheduledTask.setTaskName("test-scheduled-task");
        scheduledTask.setCron("0/1 * * ? * ?");
        //scheduledTask.setCreateTime();
        return scheduledTask;
    }
}

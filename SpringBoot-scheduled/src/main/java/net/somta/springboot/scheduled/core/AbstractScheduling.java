package net.somta.springboot.scheduled.core;


import net.somta.springboot.scheduled.model.ScheduledTask;

import java.util.List;

/**
 * @Description: 定时任务
 * @Author: Rachel
 * @DateTime: 2022/8/21 17:03
 */
public abstract class AbstractScheduling {

    /**
     * 获取定时任务实体类
     * @return 定时任务时间实体类
     */
    protected abstract ScheduledTask getScheduledTask();

    /**
     * 执行定时任务内容
     */
    protected abstract void scheduled();

    protected void execute(){
        System.out.println("执行定时任务: "+ getScheduledTask().getTaskName());
        System.out.println("定时任务表达式: <{}>" + getScheduledTask().getCron());
        this.scheduled();

    }
}

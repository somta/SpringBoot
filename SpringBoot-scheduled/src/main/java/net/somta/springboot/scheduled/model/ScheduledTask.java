package net.somta.springboot.scheduled.model;

import java.io.Serializable;

/**
 * @Description:
 * @Author: Rachel
 * @DateTime: 2022/8/21 17:06
 */
public class ScheduledTask implements Serializable {

    private String taskName;

    private String cron;

    private String createTime;

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public String getCron() {
        return cron;
    }

    public void setCron(String cron) {
        this.cron = cron;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }
}


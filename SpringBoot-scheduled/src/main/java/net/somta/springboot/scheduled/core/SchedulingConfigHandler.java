package net.somta.springboot.scheduled.core;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;

import javax.annotation.Resource;

/**
 * @Description:
 * @Author: Rachel
 * @DateTime: 2022/8/22 16:14
 */
@Configuration
public class SchedulingConfigHandler extends AbstractSchedulingConfigurer {

    @Resource
    private ThreadPoolTaskScheduler taskScheduler;


    @Override
    protected TaskScheduler getTaskScheduler() {
        return this.taskScheduler;
    }
}


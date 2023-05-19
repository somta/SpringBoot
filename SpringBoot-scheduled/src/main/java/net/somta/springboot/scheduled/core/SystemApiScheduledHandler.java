package net.somta.springboot.scheduled.core;

import net.somta.springboot.scheduled.model.ScheduledTask;
import net.somta.springboot.scheduled.service.SystemScheduledService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @Description: api定时任务
 * @Author: Rachel
 * @DateTime: 2022/8/21 17:37
 */
@Component
public class SystemApiScheduledHandler extends AbstractScheduling {

    @Resource
    private SystemScheduledService systemScheduledService;

    /*@Resource
    private SystemApiService systemApiService;*/

    @Override
    protected ScheduledTask getScheduledTask() {
        return systemScheduledService.queryScheduledTask();
        /*ScheduledQueryDO scheduledQueryDO = new ScheduledQueryDO();
        scheduledQueryDO.setCode(CronCodeEnum.SYSTEM_WHITE_API.getCode());
        ScheduledDO scheduledDO = systemScheduledRepository.query(scheduledQueryDO);
        return new ScheduledTask(scheduledDO.getName(),scheduledDO.getCron(), DateUtils.formatNowDate());*/
    }

    @Override
    protected void scheduled() {
        // 同步白名单至redis
        System.out.println("执行scheduled。。。");
        //systemApiService.syncSystemApi();
    }
}


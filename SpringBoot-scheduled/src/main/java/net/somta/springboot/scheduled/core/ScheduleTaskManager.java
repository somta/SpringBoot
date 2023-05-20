package net.somta.springboot.scheduled.core;

import net.somta.springboot.scheduled.model.ScheduledTask;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ScheduledFuture;

@Component
public class ScheduleTaskManager {

	private final Map<String, ScheduledFuture<?>> futureMap = new ConcurrentHashMap<String, ScheduledFuture<?>>();

	@Autowired
	private ThreadPoolTaskScheduler threadPoolTaskScheduler;
	
	public void start(AbstractTask task, ScheduledTask scheduledTask) {
		ScheduledTrigger trigger = new ScheduledTrigger(scheduledTask.getTaskCron());
		ScheduledFuture<?> future = threadPoolTaskScheduler.schedule(task, trigger);
		futureMap.put(scheduledTask.getTaskId(), future);
	}
	
	public void stop(String taskId) {
		if(!StringUtils.isEmpty(taskId)) {
			ScheduledFuture<?> future = futureMap.get(taskId);
			if (future != null) {
				future.cancel(true);
				futureMap.remove(taskId);
			}
		}
	}
	
	public void restart(AbstractTask task, ScheduledTask scheduledTask) {
		stop(scheduledTask.getTaskId());
		start(task, scheduledTask);
	}

	public void shutDown() {
		Collection<ScheduledFuture<?>> values = futureMap.values();
		for(ScheduledFuture<?> future:values) {
			if (future != null) {
				future.cancel(true);
			}
		}
		futureMap.clear();
	}

}

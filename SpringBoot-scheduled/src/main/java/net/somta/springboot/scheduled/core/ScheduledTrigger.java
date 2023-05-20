package net.somta.springboot.scheduled.core;

import org.springframework.scheduling.Trigger;
import org.springframework.scheduling.TriggerContext;
import org.springframework.scheduling.support.CronTrigger;

import java.util.Date;

public class ScheduledTrigger implements Trigger {
	
	private String cron;
	
	@SuppressWarnings("unused")
	private ScheduledTrigger() {}
	
	public ScheduledTrigger(String cron) {
		this.cron = cron;
	}

	@Override
	public Date nextExecutionTime(TriggerContext triggerContext) {
		CronTrigger cronTrigger = new CronTrigger(cron);
		Date nextExecutionTime = cronTrigger.nextExecutionTime(triggerContext);
		return nextExecutionTime;
	}

}

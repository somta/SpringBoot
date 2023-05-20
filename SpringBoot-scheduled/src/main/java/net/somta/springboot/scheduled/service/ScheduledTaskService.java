package net.somta.springboot.scheduled.service;

import net.somta.springboot.scheduled.model.ScheduledTask;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Service
public class ScheduledTaskService {
	
	private List<ScheduledTask> scheduledTasks = new ArrayList<>();

	@PostConstruct
	public void initData(){
		scheduledTasks.add(new ScheduledTask("T001","测试定时任务1","0/5 * * * * ?","log"));
		scheduledTasks.add(new ScheduledTask("T002","测试定时任务2","0/10 * * * * ?","db"));
	}
	
	public List<ScheduledTask> getScheduledTasks() {
		return scheduledTasks;
	}
	
	public ScheduledTask getScheduledTask(String taskId) {
		ScheduledTask task = null;
		for (ScheduledTask scheduledTask: scheduledTasks) {
			if(taskId.equals(scheduledTask.getTaskId())){
				task = scheduledTask;
			}
		}
		if(null == task) {
			throw new RuntimeException("查询异常");
		}
		return task;
	}


}

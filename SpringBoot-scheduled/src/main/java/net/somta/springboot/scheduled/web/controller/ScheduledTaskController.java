package net.somta.springboot.scheduled.web.controller;


import net.somta.springboot.scheduled.core.AbstractTask;
import net.somta.springboot.scheduled.core.ScheduleTaskManager;
import net.somta.springboot.scheduled.model.ScheduledTask;
import net.somta.springboot.scheduled.service.ScheduledTaskService;
import net.somta.springboot.scheduled.task.TaskFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ScheduledTaskController {

	@Autowired
	private ScheduleTaskManager scheduleTaskManager;
	
	@Autowired
	private ScheduledTaskService taskService;
	
	@GetMapping("startAll")
	public void startAll() {
		List<ScheduledTask> scheduledTasks = taskService.getScheduledTasks();
		for(ScheduledTask scheduledTask: scheduledTasks) {
			AbstractTask task = TaskFactory.getTask(scheduledTask.getTaskType());
			scheduleTaskManager.start(task, scheduledTask);
		}
	}
	
	@GetMapping("shutDown")
	public void shutDown() {
		scheduleTaskManager.shutDown();
	}
	
	@GetMapping("start/{taskId}")
	public void start(@PathVariable("taskId") String taskId) {
		ScheduledTask scheduledTask = taskService.getScheduledTask(taskId);
		AbstractTask task = TaskFactory.getTask(scheduledTask.getTaskType());
		scheduleTaskManager.start(task, scheduledTask);
	}

	@GetMapping("stop/{taskId}")
	public void stop(@PathVariable("taskId") String taskId) {
		scheduleTaskManager.stop(taskId);
	}
	
	@GetMapping("restart/{taskId}")
	public void restart(@PathVariable("taskId") String taskId){
		ScheduledTask scheduledTask = taskService.getScheduledTask(taskId);
		AbstractTask task = TaskFactory.getTask(scheduledTask.getTaskType());
		scheduleTaskManager.restart(task, scheduledTask);
	}

}

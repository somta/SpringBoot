package net.somta.springboot.scheduled.model;

public class ScheduledTask {

	private String taskId;

	private String taskName;

	private String taskCron;

	private String taskType;


	public ScheduledTask(String taskId, String taskName, String taskCron, String taskType) {
		this.taskId = taskId;
		this.taskName = taskName;
		this.taskCron = taskCron;
		this.taskType = taskType;
	}

	public String getTaskId() {
		return taskId;
	}

	public void setTaskId(String taskId) {
		this.taskId = taskId;
	}

	public String getTaskName() {
		return taskName;
	}

	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}

	public String getTaskCron() {
		return taskCron;
	}

	public void setTaskCron(String taskCron) {
		this.taskCron = taskCron;
	}

	public String getTaskType() {
		return taskType;
	}

	public void setTaskType(String taskType) {
		this.taskType = taskType;
	}
}

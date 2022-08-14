package com.barclays.tasktracker.dto;

import java.time.LocalDate;

public class TaskDTO {
	
	private Integer taskId;
	private String taskName;
	private LocalDate taskDate;
	
	public Integer getTaskId() {
		return taskId;
	}
	
	public void setTaskId(Integer taskId) {
		this.taskId = taskId;
	}
	
	public String getTaskName() {
		return taskName;
	}
	
	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}
	
	public LocalDate getTaskDate() {
		return taskDate;
	}
	
	public void setTaskDate(LocalDate taskDate) {
		this.taskDate = taskDate;
	}

	@Override
	public String toString() {
		return String.format("Task [taskId=%d, taskName=%s, taskDate=%t]", taskId, taskName, taskDate);
	}
}

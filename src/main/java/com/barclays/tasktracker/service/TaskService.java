package com.barclays.tasktracker.service;

import java.util.List;

import com.barclays.tasktracker.dto.TaskDTO;
import com.barclays.tasktracker.exception.TaskTrackerException;

public interface TaskService {
	public List<TaskDTO> getAllTasks() throws TaskTrackerException;
	public TaskDTO getTask(Integer id) throws TaskTrackerException;
	public Integer addTask(TaskDTO task) throws TaskTrackerException;
}

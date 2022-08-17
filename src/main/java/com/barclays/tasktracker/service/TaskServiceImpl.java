package com.barclays.tasktracker.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.barclays.tasktracker.dto.TaskDTO;
import com.barclays.tasktracker.entity.Task;
import com.barclays.tasktracker.exception.TaskTrackerException;
import com.barclays.tasktracker.repository.TaskRepository;

@Service(value = "taskService")
@Transactional
public class TaskServiceImpl implements TaskService {

	@Autowired
	TaskRepository taskRepository;
	
	@Override
	public List<TaskDTO> getAllTasks() throws TaskTrackerException {
		Iterable<Task> iterTasks = taskRepository.findAll();
		
		List<TaskDTO> tasks = new ArrayList<>();
		iterTasks.forEach(task -> {
			TaskDTO taskDTO = new TaskDTO();
			taskDTO.setTaskId(task.getTaskId());
			taskDTO.setTaskName(task.getTaskName());
			taskDTO.setTaskDate(task.getTaskDate());
			tasks.add(taskDTO);
		});
		
		if (tasks.isEmpty())
			throw new TaskTrackerException("Task Not Found");
		
		return tasks;
	}
	
	@Override
	public TaskDTO getTask(Integer id) throws TaskTrackerException {
		Optional<Task> opt = taskRepository.findById(id);
		if (opt.isEmpty())
			throw new TaskTrackerException("Task not found");
		
		Task t = opt.get();
		TaskDTO task = new TaskDTO();
		task.setTaskId(t.getTaskId());
		task.setTaskName(t.getTaskName());
		task.setTaskDate(t.getTaskDate());
		
		return task;
	}

	@Override
	public Integer addTask(TaskDTO task) throws TaskTrackerException {
		Task taskEntity = new Task();
		taskEntity.setTaskId(task.getTaskId());
		taskEntity.setTaskName(task.getTaskName());
		taskEntity.setTaskDate(task.getTaskDate());
		
		Task newTask = taskRepository.save(taskEntity);
		
		return newTask.getTaskId();
	}

}

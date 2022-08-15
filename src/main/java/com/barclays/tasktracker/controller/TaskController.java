package com.barclays.tasktracker.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.barclays.tasktracker.dto.TaskDTO;
import com.barclays.tasktracker.exception.TaskTrackerException;
import com.barclays.tasktracker.service.TaskService;

@RestController
@RequestMapping("/api")
public class TaskController {
	
	@Autowired
	private TaskService taskService;
	
	@GetMapping("/tasks")
	public ResponseEntity<List<TaskDTO>> GetAllTasks() throws TaskTrackerException {
		List<TaskDTO> tasks = taskService.getAllTasks();
		return new ResponseEntity<>(tasks, HttpStatus.OK);
	}
	
	@PostMapping("/tasks")
	public ResponseEntity<String> AddTask(@RequestBody TaskDTO task) throws TaskTrackerException {
		Integer id = taskService.addTask(task);
		return new ResponseEntity<>("Task created successfully", HttpStatus.OK);
	}
	
	@DeleteMapping("/tasks")
	public ResponseEntity<String> DeleteTask(@RequestBody Integer id) throws TaskTrackerException {
		return new ResponseEntity<>("Task deleted successfully", HttpStatus.OK);
	}
 }

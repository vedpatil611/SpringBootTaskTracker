package com.barclays.tasktracker.repository;

import org.springframework.data.repository.CrudRepository;

import com.barclays.tasktracker.entity.Task;

public interface TaskRepository extends CrudRepository<Task, Integer> {

}

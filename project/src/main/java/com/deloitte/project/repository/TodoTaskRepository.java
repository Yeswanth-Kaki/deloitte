package com.deloitte.project.repository;

import org.springframework.data.repository.CrudRepository;

import com.deloitte.project.model.TodoTask;

public interface TodoTaskRepository extends CrudRepository<TodoTask,Integer>{

}

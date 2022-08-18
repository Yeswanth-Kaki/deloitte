package com.deloitte.project.repository;

import org.springframework.data.repository.CrudRepository;

import com.deloitte.project.model.TodoUser;

public interface UserRepository extends CrudRepository<TodoUser,Integer>{
	TodoUser findByEmail(String name);
	
}

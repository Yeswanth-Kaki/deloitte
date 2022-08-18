package com.deloitte.project.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.deloitte.project.model.TodoTask;
import com.deloitte.project.repository.TodoTaskRepository;

@Component
public class TodoTaskDataLoader implements CommandLineRunner{

	private final Logger log = LoggerFactory.getLogger(TodoTaskDataLoader.class);
	
	@Autowired
	private TodoTaskRepository todoTaskRepository;

	@Override
	public void run(String... args) throws Exception {
		loadSeedData();
		
	}
	
	private void loadSeedData() {
		if(todoTaskRepository.count()==0) {
			TodoTask todoTask1 = new TodoTask("Task1", "InProgress");
			TodoTask todoTask2 = new TodoTask("Task2", "InProgress");
			
			todoTaskRepository.save(todoTask1);
			todoTaskRepository.save(todoTask2);
		}
		
		log.info("Number of TodoTaskItems: {}", todoTaskRepository.count());
	}
}


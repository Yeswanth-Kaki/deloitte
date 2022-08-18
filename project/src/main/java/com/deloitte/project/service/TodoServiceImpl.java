package com.deloitte.project.service;

import java.time.Instant;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.servlet.ModelAndView;

import com.deloitte.project.model.TodoTask;
import com.deloitte.project.repository.TodoTaskRepository;

@Service
public class TodoServiceImpl implements TodoService{
	private final Logger log = LoggerFactory.getLogger(TodoServiceImpl.class);
	
	@Autowired
	private TodoTaskRepository todoTaskRepository;

	@Override
	public ModelAndView todoIndexService() {
		log.info("Inside TodoServiceImpl, method : todoIndex");
		
		ModelAndView modelAndView = new ModelAndView("todo-task");
		modelAndView.addObject("todoTasks",todoTaskRepository.findAll());
		return modelAndView;
	}

	@Override
	public String updateTodoFormService(Integer id, Model model) {
		log.info("Inside TodoServiceImpl, method : updateTodoFormService");
		
		TodoTask todoTask = todoTaskRepository.findById(id).orElseThrow(
				() -> new IllegalArgumentException("TodoTask id: " + id + " not found"));
		
		model.addAttribute("todo", todoTask);
        return "update-todo-task";
	}

	@Override
	public String updateTodoTaskService(Integer id, TodoTask todoTask, BindingResult result, Model model) {
		log.info("Inside TodoServiceImpl, method : updateTodoTaskService");
		
		if (result.hasErrors()) {
        	todoTask.setId(id);
            return "update-todo-task";
        }
		
		if(todoTask.getCompleted()) {
			todoTask.setStatus("Completed");
		}

        todoTask.setModifiedDate(Instant.now());
        todoTaskRepository.save(todoTask);
        
        return "redirect:/todo-task";
	}

	@Override
	public String deleteTodoService(Integer id, Model model) {
		log.info("Inside TodoServiceImpl, method : deleteTodoService");
		
		TodoTask todoTask = todoTaskRepository.findById(id).orElseThrow(
				() -> new IllegalArgumentException("TodoTask id: " + id + " not found"));
		
		todoTaskRepository.delete(todoTask);
		return "redirect:/todo-task";
	}

	@Override
	public String showCreateFormService(TodoTask todoTask) {
		log.info("Inside TodoServiceImpl, method : deleteTodoService");
		
		return "add-todo-task";
	}

	@Override
	public String createTodoItemService(TodoTask todoTask, BindingResult result, Model model) {
		log.info("Inside TodoServiceImpl, method : createTodoItemService");
		
		if (result.hasErrors()) {
            return "add-todo-item";
        }

        todoTask.setTargetDate(Instant.now());
        todoTask.setModifiedDate(Instant.now());
        todoTask.setCompleted(Boolean.FALSE);
        todoTask.setStatus("In Progress");
        todoTaskRepository.save(todoTask);
        return "redirect:/todo-task";
	} 
	
	

}

package com.deloitte.project.controller;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.deloitte.project.model.TodoTask;
import com.deloitte.project.service.TodoService;

@Controller
public class TodoController {
	private final Logger log = LoggerFactory.getLogger(TodoController.class);
	
	@Autowired
	private TodoService todoService;
	
	@GetMapping("/todo-task")
	public ModelAndView todoIndex() {
		log.info("Inside TodoController, method : todoIndex");
		
		return todoService.todoIndexService();
	}
	
	@GetMapping("/edit/todo/{id}")
	public String updateTodoForm(@PathVariable("id") Integer id, Model model) {
		log.info("Inside TodoController, method : updateTodoForm");
		
		return todoService.updateTodoFormService(id, model);
	}
	
	@PostMapping("/todo/task/{id}")
    public String updateTodoTask(@PathVariable("id") Integer id, @Valid TodoTask todoTask, BindingResult result, Model model) {
		log.info("Inside TodoController, method : updateTodoTask");
		
		return todoService.updateTodoTaskService(id, todoTask, result, model);
    }
	
	@GetMapping("/delete/todo/{id}")
	public String deleteTodo(@PathVariable("id") Integer id, Model model) {
		log.info("Inside TodoController, method : deleteTodo");
		
		return todoService.deleteTodoService(id, model);
	}
	
	@GetMapping("/create-todo")
    public String showCreateForm(TodoTask todoTask){
		log.info("Inside TodoController, method : showCreateForm");
        return todoService.showCreateFormService(todoTask);
    }
	
	@PostMapping("/todo")
    public String createTodoItem(@Valid TodoTask todoTask, BindingResult result, Model model) {
		log.info("Inside TodoController, method : createTodoItem");
        return todoService.createTodoItemService(todoTask, result, model);
    }

}

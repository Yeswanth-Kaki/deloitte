package com.deloitte.project.service;

import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.servlet.ModelAndView;

import com.deloitte.project.model.TodoTask;

public interface TodoService {

	ModelAndView todoIndexService();
	String updateTodoFormService(Integer id, Model model);
	String updateTodoTaskService(Integer id, TodoTask todoTask, BindingResult result, Model model);
	String deleteTodoService(Integer id, Model model);
	String showCreateFormService(TodoTask todoTask);
	String createTodoItemService(TodoTask todoTask, BindingResult result, Model model);
}

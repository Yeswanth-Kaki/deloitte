package com.deloitte.project.controller;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.deloitte.project.model.TodoUser;
import com.deloitte.project.service.UserService;

@Controller
public class UserController {
	
	private final Logger log = LoggerFactory.getLogger(TodoController.class);
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/")
	public String viewHomePage() {
		return "index";
	}
	
	@GetMapping("/register")
	public String registrationForm(Model model) {
		log.info("Inside UserController, method : registrationForm");
		return userService.registrationFormService(model);
	}
	
	@PostMapping("/process_register")
	public String processRegister(TodoUser todoUser) {
		log.info("Inside UserController, method : processRegister");
	    return userService.processRegisterService(todoUser);
	}
	
	@GetMapping("/login")
	public String loginForm(@Valid TodoUser todoUser, Model model) {
		log.info("Inside UserController, method : loginForm");
		return userService.loginFormService(todoUser, model);
	}
	
	@PostMapping("/process_login")
	public String processLogin(@Valid TodoUser todoUser, BindingResult result, Model model) {
		log.info("Inside UserController, method : processLogin");
		return userService.processLoginImpl(todoUser, result, model);	
	}

}

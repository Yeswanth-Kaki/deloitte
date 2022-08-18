package com.deloitte.project.service;

import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import com.deloitte.project.model.TodoUser;

public interface UserService {

	String registrationFormService(Model model);
	String processRegisterService(TodoUser todoUser);
	String loginFormService(TodoUser todoUser, Model model);
	String processLoginImpl(TodoUser todoUser, BindingResult result, Model model);
}

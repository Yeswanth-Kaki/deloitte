package com.deloitte.project.service;

import java.util.Iterator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import com.deloitte.project.model.TodoUser;
import com.deloitte.project.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService{

	private final Logger log = LoggerFactory.getLogger(UserServiceImpl.class);
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public String registrationFormService(Model model) {
		log.info("Inside UserServiceImpl, method : registrationFormService");
		
		model.addAttribute("todouser", new TodoUser());
		return "signin-form";
	}

	@Override
	public String processRegisterService(TodoUser todoUser) {
		log.info("Inside UserServiceImpl, method : processRegisterService");
		
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
	    String encodedPassword = passwordEncoder.encode(todoUser.getPassword());
	    todoUser.setPassword(encodedPassword);
	     
	    userRepository.save(todoUser);
	     
	    return "register_success";
	}

	@Override
	public String loginFormService(TodoUser todoUser, Model model) {
		log.info("Inside UserServiceImpl, method : loginFormService");
		model.addAttribute("todouser", todoUser);
		return "login-form";
	}

	@Override
	public String processLoginImpl(TodoUser todoUser, BindingResult result, Model model) {
		log.info("Inside UserServiceImpl, method : processLoginImpl");
		
		if (result.hasErrors()) {
            return "login-form";
        }
		
		return processLoginUserImpl(todoUser);
	}
	
	public String processLoginUserImpl(TodoUser todoUser) {
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String name = todoUser.getName();
		String password = todoUser.getPassword();
		
		Iterator<TodoUser> list = userRepository.findAll().iterator();
		while(list.hasNext()) {
			TodoUser user = list.next();
			if(name.equals(user.getName()) && passwordEncoder.matches(password, user.getPassword())) {
				return "redirect:/todo-task";
			}
		}
		
		
		return "error";
	}
}

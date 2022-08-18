package com.deloitte.project.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

@Entity
@Table(name = "todo_user")
public class TodoUser {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Size(min = 3, message = "name should have atleast 3 characters")
	private String name;
	
	@Size(min = 6, message = "name should have atleast 3 characters")
	private String password;
	
	@Email
	private String email;
	
	@OneToMany(targetEntity = TodoTask.class,cascade = CascadeType.ALL)
    @JoinColumn(name ="ut_fk",referencedColumnName = "id")
	private List<TodoTask> todoTasks = new ArrayList<>();
	
	public TodoUser() {
		
	}
	
	

	public TodoUser(String name, String password) {
		super();
		this.name = name;
		this.password = password;
	}



	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<TodoTask> getTodoTasks() {
		return todoTasks;
	}

	public void setTodoTasks(List<TodoTask> todoTasks) {
		this.todoTasks = todoTasks;
	}
	
	
}

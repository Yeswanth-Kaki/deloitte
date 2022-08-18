package com.deloitte.project.model;

import java.time.Instant;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "todo_task")
public class TodoTask {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String description;
	private Boolean completed;
	private Instant targetDate;
	private Instant modifiedDate;
	private String status;
	
	public TodoTask() {
		
	}
	
	
	public TodoTask(String description, String status) {
		this.description = description;
		this.completed = Boolean.FALSE;
		this.targetDate = Instant.now();
		this.modifiedDate = Instant.now();
		this.status = status;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Boolean getCompleted() {
		return completed;
	}
	public void setCompleted(Boolean completed) {
		this.completed = completed;
	}
	public Instant getTargetDate() {
		return targetDate;
	}
	public void setTargetDate(Instant targetDate) {
		this.targetDate = targetDate;
	}
	public Instant getModifiedDate() {
		return modifiedDate;
	}
	public void setModifiedDate(Instant modifiedDate) {
		this.modifiedDate = modifiedDate;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	
}

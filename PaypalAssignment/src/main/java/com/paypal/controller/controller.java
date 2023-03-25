package com.paypal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.paypal.exception.sprintException;
import com.paypal.exception.taskException;
import com.paypal.exception.userException;
import com.paypal.model.sprint;
import com.paypal.model.task;
import com.paypal.model.user;
import com.paypal.service.service;

@RestController
@RequestMapping("api/")
public class controller {
	
	@Autowired
	private service services;
	
	
	@PostMapping("create/sprint")
	public ResponseEntity<sprint> savesprint(@RequestBody sprint sprint){
		sprint s=services.createSprint(sprint);
		return new ResponseEntity<sprint>(s,HttpStatus.CREATED);
	}

	
	@PostMapping("create/user")
	public ResponseEntity<user> saveuser(@RequestBody user user){
		user u=services.createuser(user);
		return new ResponseEntity<user>(u,HttpStatus.CREATED);
	}
	
	@PostMapping("assignTask/{sprintId}/{userId}")
	public ResponseEntity<task> taskhandler(@PathVariable Integer sprintId,@RequestBody task task,Integer userId) throws sprintException, userException{
		
		task created=services.addTaskToSprint(sprintId, task,userId);
		
		return new ResponseEntity<task>(created,HttpStatus.CREATED);
		
	}
	
	@PutMapping("changeassignee/{taskId}/{userId}")
	public ResponseEntity<task> updateassignee(@PathVariable Integer taskId,@PathVariable Integer userId) throws taskException, userException
	{
		task asigneeupdated=services.changeTaskAssignee(taskId, userId);
		return new ResponseEntity<task>(asigneeupdated,HttpStatus.OK);
	}
	
	@PutMapping("changestatus/{taskId}/{status}")
	public ResponseEntity<task> updatstatus(@PathVariable Integer taskId,@PathVariable String status) throws taskException, userException
	{
		task statusupdated=services.changeTaskStatus(taskId, status);
		return new ResponseEntity<task>(statusupdated,HttpStatus.OK);
	}
	
	@GetMapping("taskBySprint/{sprintId}")
	public ResponseEntity<List<task>> getalltaskbysprint(@PathVariable Integer sprintId) throws sprintException
	{
		List<task> get=services.getTasksBySprint(sprintId);
		return new ResponseEntity<List<task>>(get,HttpStatus.OK);
		
	}
	
	@GetMapping("taskByUser/{userId}")
	public ResponseEntity<List<task>> getalltaskbyuser(@PathVariable Integer userId) throws sprintException, userException
	{
		List<task> users=services.getTasksByUser(userId);
		return new ResponseEntity<List<task>>(users,HttpStatus.OK);
		
	}
}

package com.paypal.service;

import java.util.List;

import com.paypal.exception.sprintException;
import com.paypal.exception.taskException;
import com.paypal.exception.userException;
import com.paypal.model.sprint;
import com.paypal.model.task;
import com.paypal.model.user;



public interface service {
	
	//Creating new sprint
	public sprint createSprint(sprint sprint) ;
	
	//creating user
	public user createuser(user user);
	
	//Adding task to sprint
	public task addTaskToSprint( Integer sprintId, task task,Integer userid) throws sprintException,userException;
	
	//to change the user to the task assigned
	public task changeTaskAssignee(Integer taskid, Integer userid) throws userException, taskException;

	//to update the status of the task
	public task changeTaskStatus(Integer taskId, String status) throws taskException;
	
	//All task assigned to particular user
	public List<task> getTasksByUser( Integer userId) throws userException;
	
	
	//All task of that sprint
	public List<task> getTasksBySprint( Integer sprintId) throws sprintException;

}

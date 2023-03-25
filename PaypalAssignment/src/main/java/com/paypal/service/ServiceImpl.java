package com.paypal.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.paypal.exception.sprintException;
import com.paypal.exception.taskException;
import com.paypal.exception.userException;
import com.paypal.model.sprint;
import com.paypal.model.task;
import com.paypal.model.user;
import com.paypal.repository.sprintRepo;
import com.paypal.repository.taskRepo;
import com.paypal.repository.userRepo;

@Service
public class ServiceImpl implements service{
	
	@Autowired
	public sprintRepo srepo;
	
	@Autowired
	public taskRepo trepo;
	
	@Autowired
	public userRepo urepo;
	
	

	@Override
	public sprint createSprint(sprint sprint) {
	
		sprint ss=srepo.save(sprint);
		
		return ss;
		
	}
		
	@Override
	public user createuser(user user) {
		user usercreated=urepo.save(user);
		return usercreated;
	}
	

	@Override
	public task addTaskToSprint(Integer sprintId, task task,Integer userId) throws sprintException ,userException{
	
		Optional<sprint> sprint=srepo.findById(sprintId);
		
		Optional<user> user=urepo.findById(userId);
		
		if(sprint.isPresent() && user.isPresent())
		{
			
			sprint present=sprint.get();
			
			user userpresent=user.get();
		
			present.getTasks().add(task);
			
			userpresent.getTasks().add(task);
			task.setSprint(present);
			task.setUser(userpresent);
			
			trepo.save(task);
			urepo.save(userpresent);
			srepo.save(present);
		
			
		return	trepo.save(task);
		}
		else
		{
			throw new sprintException("sprint not found with this id");
		}
		
	}


	
	@Override
	public List<task> getTasksBySprint(Integer sprintId) throws sprintException {
		 Optional<sprint> sprint = srepo.findById(sprintId);
		 
		 if(sprint.isPresent())
		 {
			 sprint s=sprint.get();
			List<task> task=s.getTasks();
			
			return task;
		 }
		            
		 throw new sprintException("sprint not found with this id");
	}


	@Override
	public List<task> getTasksByUser(Integer userId) throws userException {
		
         Optional<user> user = urepo.findById(userId);
		 
		 if(user.isPresent())
		 {
			 user u=user.get();
			List<task> task=u.getTasks();
			
			return task;
		 }
		            
		 throw new userException("user not found with this id");
	}

	@Override
	public task changeTaskAssignee(Integer taskid, Integer userid) throws userException, taskException {
		task task = trepo.findById(taskid).orElseThrow(() -> new taskException("task not found"));

		Optional<user> user=urepo.findById(userid);
		
		if(user.isEmpty())
		{
			throw new userException("User Not FOund");
		}
		

		task.setUser(user.get());

		return trepo.save(task);
		
		
	}

	@Override
	public task changeTaskStatus(Integer taskId, String status) throws taskException {
		
		task task = trepo.findById(taskId).orElseThrow(() -> new taskException("task not found"));

		
		task.setStatus(status);
		
		
		return trepo.save(task);
	}




}

package com.techlify.rbac.controller;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.jsondoc.core.annotation.Api;
import org.jsondoc.core.annotation.ApiBodyObject;
import org.jsondoc.core.annotation.ApiMethod;
import org.jsondoc.core.annotation.ApiResponseObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.techlify.commons.Constants;
import com.techlify.rbac.commons.Result;
import com.techlify.rbac.model.Role;
import com.techlify.rbac.model.User;
import com.techlify.rbac.model.ViewTask;
import com.techlify.rbac.repository.RoleRepository;
import com.techlify.rbac.repository.TaskRepository;
import com.techlify.rbac.repository.UserRepository;

@RestController
@RequestMapping(value = "/rbac")
@Api(description = "The rbac controller", name = Constants.RBAC_GROUP)
public class RbacController {
	@Autowired
	private UserRepository userRepository;

	@Autowired
	private RoleRepository roleRepository;

	@Autowired
	private TaskRepository taskRepository;

	/*
	 * GET requests
	 */
	@ApiMethod(id = Constants.RBAC_GROUP + "_FIND_ALL_AUTHORIZED_TASKS", description = "VIEW ALL AUTHORIZED TASKS")
	@RequestMapping(value = { "/authorized-tasks" }, method = RequestMethod.GET)
	public @ApiResponseObject @ResponseBody List<ViewTask> getAllUsers() {
		
		return null;
	}
	
	/*
	 * POST requests
	 */
	@ApiMethod(id = Constants.RBAC_GROUP + "_FIND_ALL_AUTHORIZED_TASKS", description = "VIEW ALL AUTHORIZED TASKS")
	@RequestMapping(value = { "/authorized-tasks" }, method = RequestMethod.POST)
	public @ApiResponseObject @ResponseBody Result getAllAuthorizedTasks(
			@ApiBodyObject @RequestBody User user) {
		Result result = new Result("failed",
				"Ether Role is null or user alreday exists");
		Set<ViewTask> allViewTasks	=	new HashSet<ViewTask>();	
		try {
			User existingUser	=	userRepository.findByUserName(user.getUserName());
			if (existingUser != null){
				List<Role> roles	=	existingUser.getRoles();
				Iterator<Role> rolesIterator	=	roles.iterator();
				while (rolesIterator.hasNext()) {
					Role role	=	rolesIterator.next();
					List<ViewTask> viewTasksForRole = role.getViewTasks();
					Iterator<ViewTask> iterator = viewTasksForRole.iterator();
					while(iterator.hasNext()){
						ViewTask next = iterator.next();
						if(next.isDeveloperTask()==false && next.isDispay()==true){
							allViewTasks.add(next);
						}
					}
					
				}
				System.out.println("allViewTasks "+allViewTasks);
				return new Result("Success", allViewTasks);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;

	}

}
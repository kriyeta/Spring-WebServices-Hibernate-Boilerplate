package com.techlify.rbac.controller;

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
import com.techlify.rbac.model.Task;
import com.techlify.rbac.repository.TaskRepository;

@RestController
@RequestMapping(value = "/task")
@Api(description = "The Task controller", name = Constants.TASK_GROUP)
public class TaskController {
	@Autowired
	private TaskRepository taskRepository;

	/*
	 * GET requests
	 */
	


	/*
	 * POST requests
	 */
	@ApiMethod(id = Constants.TASK_GROUP + "_ADD", description = "ADD NEW TASK")
	@RequestMapping(value = { "/add" }, method = RequestMethod.POST)
	public @ApiResponseObject @ResponseBody Result saveTask(
			@ApiBodyObject @RequestBody Task task) {
		
		try {
			Task existingTask	=	taskRepository.findByName(task.getName());
			if(existingTask!=null){
				task.setTaskId(existingTask.getTaskId());
				if(existingTask.getDisplayName()==null){
					task.setDisplayName(task.getDefaultDisplayName());
				} else {
					task.setDisplayName(existingTask.getDisplayName());
				}
				taskRepository.saveAndFlush(task);
				return new Result("Success", task);
			} else {
				task.setDisplayName(task.getDefaultDisplayName());
				return new Result("Success", taskRepository.saveAndFlush(task));
			}
		} catch (Exception e) {
				return new Result("Failed", "Exception occurred "+e);
		}		
	}

	/*
	 * DELETE requests
	 */
	

	/*
	 * PUT requests
	 */
	

}
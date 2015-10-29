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
import com.techlify.rbac.model.ViewTask;
import com.techlify.rbac.repository.ViewTaskRepository;

@RestController
@RequestMapping(value = "/viewtask")
@Api(description = "The Task controller", name = Constants.TASK_GROUP)
public class ViewTaskController {
	@Autowired
	private ViewTaskRepository viewTaskRepository;

	/*
	 * GET requests
	 */
	


	/*
	 * POST requests
	 */
	@ApiMethod(id = Constants.VIEW_TASK_GROUP + "_ADD", description = "ADD NEW VIEW TASK")
	@RequestMapping(value = { "/add" }, method = RequestMethod.POST)
	public @ApiResponseObject @ResponseBody Result saveViewTask(
			@ApiBodyObject @RequestBody ViewTask viewTask) {
				return null;
		
//		try {
//			Task existingTask	=	taskRepository.findByName(task.getName());
//			if(existingTask!=null){
//				task.setTaskId(existingTask.getTaskId());
//				if(existingTask.getDisplayName()==null){
//					task.setDisplayName(task.getDefaultDisplayName());
//				} else {
//					task.setDisplayName(existingTask.getDisplayName());
//				}
//				taskRepository.saveAndFlush(task);
//				return new Result("Success", task);
//			} else {
//				task.setDisplayName(task.getDefaultDisplayName());
//				return new Result("Success", taskRepository.saveAndFlush(task));
//			}
//		} catch (Exception e) {
//				return new Result("Failed", "Exception occurred "+e);
//		}		
	}

	/*
	 * DELETE requests
	 */
	

	/*
	 * PUT requests
	 */
	

}
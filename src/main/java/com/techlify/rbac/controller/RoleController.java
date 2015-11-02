package com.techlify.rbac.controller;

import java.util.List;

import org.jsondoc.core.annotation.Api;
import org.jsondoc.core.annotation.ApiBodyObject;
import org.jsondoc.core.annotation.ApiMethod;
import org.jsondoc.core.annotation.ApiPathParam;
import org.jsondoc.core.annotation.ApiQueryParam;
import org.jsondoc.core.annotation.ApiResponseObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.techlify.commons.Constants;
import com.techlify.rbac.commons.Result;
import com.techlify.rbac.model.Role;
import com.techlify.rbac.repository.RoleRepository;

@RestController
@RequestMapping(value = "/role")
@Api(description = "The role controller", name = Constants.ROLE_GROUP)
public class RoleController {
	@Autowired
	private RoleRepository roleRepository;

	/*
	 * GET requests
	 */
	@ApiMethod(id = Constants.ROLE_GROUP + "_FIND_ALL", description = "VIEW ALL ROLES")
	@RequestMapping(value = { "/all" }, method = RequestMethod.GET)
	public @ApiResponseObject @ResponseBody Result getAllRoles() {
		try{
			List<Role> roles = (List<Role>) roleRepository.findAll();
			return new Result("Success", roles);
		} catch(Exception e){
			return new Result("Failed", e);
		}
	}

	@ApiMethod(id = Constants.ROLE_GROUP + "_FIND_BY_NAME", description = "VIEW ROLE BY NAME")
	@RequestMapping(value = { "/" }, method = RequestMethod.GET)
	public @ApiResponseObject @ResponseBody Result getRoleByName(
			@ApiQueryParam(name = "name", description = "The name of the role") @RequestParam("name") String name) {
		Role role = roleRepository.findByName(name);
		if (role == null)
			return new Result("Failed", role);
		else
			return new Result("Success", role);
	}

	@ApiMethod(id = Constants.ROLE_GROUP + "_FIND_BY_ID", description = "VIEW ROLE BY ID")
	@RequestMapping(value = { "/{id}" }, method = RequestMethod.GET)
	public @ApiResponseObject @ResponseBody Result getRoleById(
			@ApiPathParam(name = "id", description = "The id of the role") @PathVariable("id") Long id) {
		Role role = roleRepository.findOne(id);
		if (role == null)
			return new Result("Failed", role);
		else
			return new Result("Sucess", role);
	}


	/*
	 * POST requests
	 */
	@ApiMethod(id = Constants.ROLE_GROUP + "_ADD", description = "ADD NEW ROLE")
	@RequestMapping(value = { "/add" }, method = RequestMethod.POST)
	public @ApiResponseObject @ResponseBody Result saveRole(
			@ApiBodyObject @RequestBody Role role) {
		Result result = new Result("Failed",
				"Ether Role is null or user alreday exists");
		try {
			if (role != null
					&& roleRepository.findByName(role.getName()) == null)
				result = new Result("Success", roleRepository.saveAndFlush(role));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;

	}

	/*
	 * DELETE requests
	 */
	@ApiMethod(id = Constants.ROLE_GROUP + "_DELETE_ALL", description = "DELETE ALL ROLES")
	@RequestMapping(value = { "/all" }, method = RequestMethod.DELETE)
	public @ApiResponseObject @ResponseBody String removeAllRoles() {
		roleRepository.deleteAll();
		return "All roles deleted";
	}

	@ApiMethod(id = Constants.ROLE_GROUP + "_DELETE_BY_ID", description = "DELETE ROLE")
	@RequestMapping(value = { "/{id}" }, method = RequestMethod.DELETE)
	public @ApiResponseObject @ResponseBody String removeRole(
			@ApiPathParam(name = "id", description = "The id of the role") @PathVariable("id") Long id) {
		roleRepository.delete(id);
		return "Role deleted with ID: " + id;
	}

	/*
	 * PUT requests
	 */
	@ApiMethod(id = Constants.ROLE_GROUP + "_TASK_UPDATE", description = "TASKS UPDATE")
	@RequestMapping(value = { "/task-update" }, method = RequestMethod.PUT)
	public Result roleTaskUpdate(@RequestBody Role role) {

		Role dbRole = roleRepository.findOne(role.getRoleId());
		if (dbRole == null)
			return new Result("failure", role);
		dbRole.setTasks(role.getTasks());
		roleRepository.saveAndFlush(dbRole);
		return new Result("Success",dbRole );

	}

	@ApiMethod(id = Constants.ROLE_GROUP + "_UPDATE_BY_ID", description = "UPDATE ROLE INFORMATION")
	@RequestMapping(value = { "/{id}" }, method = RequestMethod.PUT)
	public @ApiResponseObject @ResponseBody Result updateRole(@ApiPathParam(name = "id", description = "The id of the role") @PathVariable("id") Long id,
			@ApiBodyObject @RequestBody Role role) {
		Role existingRole = roleRepository.findOne(id);
		if (existingRole != null) {
			role.setTasks(existingRole.getTasks());
			role.setRoleId(existingRole.getRoleId());
			return new Result("Sucess", roleRepository.saveAndFlush(role));

		} else
			return new Result("Failed", role);
	}

}
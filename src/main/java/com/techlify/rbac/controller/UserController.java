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
import com.techlify.rbac.model.User;
import com.techlify.rbac.repository.UserRepository;

@RestController
@RequestMapping(value = "/user", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
@Api(description = "The user controller", name = "User services")
public class UserController {
	@Autowired
	private UserRepository userRepository;

	/*
	 * GET requests
	 */
	@ApiMethod(id = Constants.USER_GROUP + "_FIND_ALL", description="VIEW ALL USERS")
	@RequestMapping(value = { "/all" }, method = RequestMethod.GET)
	public @ApiResponseObject @ResponseBody List<User> getAllUsers() {
		List<User> users = (List<User>) userRepository.findAll();
		return users;
	}

	@ApiMethod(id = Constants.USER_GROUP + "_FIND_BY_NAME", description="VIEW USERS BY NAME")
	@RequestMapping(value = { "/" }, method = RequestMethod.GET)
	public @ApiResponseObject @ResponseBody List<User> getUserByName(
			@ApiQueryParam(name = "name", description = "The name of the user") @RequestParam("name") String name) {
		List<User> users = userRepository.findByName(name);
		return users;
	}

	@ApiMethod(id = Constants.USER_GROUP + "_FIND_BY_ID", description="VIEW USER BY ID")
	@RequestMapping(value = { "/{id}" }, method = RequestMethod.GET)
	public @ApiResponseObject @ResponseBody User getUserById(
			@ApiPathParam(name = "id", description = "The id of the user") @PathVariable("id") Long id) {
		User user = userRepository.findOne(id);
		return user;
	}

	/*
	 * POST requests
	 */
	@ApiMethod(id = Constants.USER_GROUP + "_ADD", description="ADD NEW USER")
	@RequestMapping(value = { "/add" }, method = RequestMethod.POST)
	public @ApiResponseObject @ResponseBody User saveUser(
			@ApiBodyObject @RequestBody User user) {
		return userRepository.save(user);
	}

	/*
	 * PUT requests
	 */
	
	@ApiMethod(id = Constants.USER_GROUP + "_UPDATE_BY_ID", description="UPDATE YOUR PROFILE")
	@RequestMapping(value = { "/{userName}/update-your-profile" }, method = RequestMethod.PUT)
	public @ApiResponseObject @ResponseBody Result updateYourProfile(@ApiPathParam(name = "userName", description = "The id of the user") @PathVariable("username") String userName,
			@ApiBodyObject @RequestBody User user) {
		User existingUser = userRepository.findByUserName(userName);
		if(existingUser != null && existingUser.getUserName().equals(user.getUserName())){
			       user.setPassword(existingUser.getPassword());
			       user.setUserId(existingUser.getUserId());
			       user.setUserName(existingUser.getUserName());
				return new  Result("Sucess",userRepository.save(user));
				
		}
		else	
			return  new  Result("Failed",user);
	}
	
	@ApiMethod(id = Constants.USER_GROUP + "_UPDATE_BY_ID", description="UPDATE USER'S PROFILE")
	@RequestMapping(value = { "/{id}/update-profile" }, method = RequestMethod.PUT)
	public @ApiResponseObject @ResponseBody Result updateUser(@ApiPathParam(name = "id", description = "The id of the user") @PathVariable("id") Long id,
			@ApiBodyObject @RequestBody User user) {
		User existingUser = userRepository.findOne(id);
		if(existingUser != null){
			       user.setPassword(existingUser.getPassword());
			       user.setUserId(existingUser.getUserId());
			       user.setUserName(existingUser.getUserName());
				return new  Result("Sucess",userRepository.saveAndFlush(user));
				
		}
		else	
			return  new  Result("Failed",user);
	}
	
	@ApiMethod(id = Constants.USER_GROUP + "_RESET_PASSWOD", description="UPDATE USER'S PASSWORD")
	@RequestMapping(value = { "/{id}/reset-password" }, method = RequestMethod.PUT)
	public @ApiResponseObject @ResponseBody Result resetPassword(
			@ApiBodyObject @RequestBody User user) {
		User existingUser = userRepository.findByUserName(user.getUserName());
		if(existingUser != null){
			       existingUser.setPassword(user.getPassword());
				return new  Result("Sucess",userRepository.saveAndFlush(existingUser));
				
		}
		else	
			return  new  Result("Failed",user);
	}

	/*
	 * DELETE requests
	 */
	@ApiMethod(id = Constants.USER_GROUP + "_DELETE_ALL", description="DELETE ALL USERS")
	@RequestMapping(value = { "/all" }, method = RequestMethod.DELETE)
	public @ApiResponseObject @ResponseBody String removeAllUsers() {
		userRepository.deleteAll();
		return "All users deleted";
	}

	@ApiMethod(id = Constants.USER_GROUP + "_DELETE_BY_ID", description="DELETE USER")
	@RequestMapping(value = { "/{id}" }, method = RequestMethod.DELETE)
	public @ApiResponseObject @ResponseBody String removeUser(
			@ApiPathParam(name = "id", description = "The id of the user") @PathVariable("id") Long id) {
		userRepository.delete(id);
		return "User deleted with ID: " + id;
	}
	
	
	@ApiMethod(id = Constants.USER_GROUP + "_AUTHENTICATE", description="AUTHENTICATE USER")
	@RequestMapping(value = { "/authenticate" }, method = RequestMethod.POST)
	public @ApiResponseObject @ResponseBody Result AuthenticateUser(
			@ApiBodyObject @RequestBody User user) {
		User existingUser =  userRepository.findByUserName(user.getUserName());
		if(existingUser != null && user !=null&& existingUser.getPassword().equals(user.getPassword()))
			return new Result("Sucess",user);
		else
			return new Result("Failed",user);
	}
	
	

}
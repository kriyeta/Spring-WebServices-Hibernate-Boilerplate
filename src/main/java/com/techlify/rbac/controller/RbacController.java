package com.techlify.rbac.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.techlify.mis.model.Product;
import com.techlify.rbac.model.Role;
import com.techlify.rbac.repository.RoleRepository;
import com.techlify.rbac.repository.TaskRepository;
import com.techlify.rbac.repository.UserRepository;

@RestController
public class RbacController {
	@Autowired
	private UserRepository userRepository;

	@Autowired
	private RoleRepository roleRepository;

	@Autowired
	private TaskRepository taskRepository;

	@RequestMapping(value = { "/role/add" }, method = RequestMethod.POST)
	public Map<String,String> createRole(@RequestBody Role request) {
		
		return null;
	
	}

}
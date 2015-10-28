package com.techlify.rbac.controller;

import org.jsondoc.core.annotation.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.techlify.commons.Constants;
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


	



}
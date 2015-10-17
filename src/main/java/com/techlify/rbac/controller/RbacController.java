package com.techlify.rbac.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

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

}
package com.techlify.rbac.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.techlify.rbac.repository.UserRepository;

@RestController
public class UserController {
	@Autowired
	private UserRepository userRepository;
}
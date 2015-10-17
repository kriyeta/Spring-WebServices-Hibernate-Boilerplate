package com.techlify.rbac.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.techlify.rbac.model.User;

@Transactional
public interface UserRepository extends JpaRepository<User, Long> {
	public User findByName(String name);

	public User findByUserName(String userName);

	public User findByEmpId(String empId);

	public User findByEmail(String email);

	public User findByMobile(String mobile);

}

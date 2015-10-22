package com.techlify.rbac.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.techlify.mis.model.Product;
import com.techlify.rbac.model.User;

@Transactional
public interface UserRepository extends JpaRepository<User, Long> {
	public List<User>  findByName(String name);

	public User findByUserName(String userName);
	
	public User findByEmpId(String empId);

	public User findByEmail(String email);

	public User findByMobile(String mobile);

}

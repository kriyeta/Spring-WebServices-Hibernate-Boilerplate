package com.techlify.rbac.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.techlify.rbac.model.Role;

@Transactional
public interface RoleRepository extends JpaRepository<Role, Long> {
	public Role findByName(String name);

}

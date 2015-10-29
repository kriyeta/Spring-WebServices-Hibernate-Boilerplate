package com.techlify.rbac.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.techlify.rbac.model.Task;

@Transactional
public interface ViewTaskRepository extends JpaRepository<Task, Long> {
	public Task findByName(String name);

	public Task findByGroup(String group);

}

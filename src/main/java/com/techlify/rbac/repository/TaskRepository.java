package com.techlify.rbac.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.techlify.rbac.model.Task;

@Transactional
public interface TaskRepository extends JpaRepository<Task, Long> {
	public Task findByName(String name);

	public Task findByDisplayName(String displayName);

	public Task findByGroup(String group);

}

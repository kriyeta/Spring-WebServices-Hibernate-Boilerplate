package com.techlify.rbac.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 * @author kamal
 *
 */

@Entity
@Table(name = "t_mis_role")
public class Role {

	@Id
	@Column(name = "id_roleid")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long roleId;

	@Column(name = "tx_name", length = 50, nullable = false)
	private String name;

	@Column(name = "tx_description", length = 200, nullable = true)
	private String description;

	@Column(name = "tx_creator_uid", length = 50, nullable = false)
	private String creatorUserId;

	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(name = "tm_role_task", joinColumns = { @JoinColumn(name = "id_roleid", referencedColumnName = "id_roleid") }, inverseJoinColumns = { @JoinColumn(name = "id_taskid", referencedColumnName = "id_taskid") })
	private List<Task> tasks;

	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(name = "tm_role_view_task", joinColumns = { @JoinColumn(name = "id_roleid", referencedColumnName = "id_roleid") }, inverseJoinColumns = { @JoinColumn(name = "id_view_taskid", referencedColumnName = "id_view_taskid") })
	private List<ViewTask> viewTasks;

	public long getRoleId() {
		return roleId;
	}

	public void setRoleId(long roleId) {
		this.roleId = roleId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCreatorUserId() {
		return creatorUserId;
	}

	public void setCreatorUserId(String creatorUserId) {
		this.creatorUserId = creatorUserId;
	}

	public List<Task> getTasks() {
		return tasks;
	}

	public void setTasks(List<Task> tasks) {
		this.tasks = tasks;
	}

	public List<ViewTask> getViewTasks() {
		return viewTasks;
	}

	public void setViewTasks(List<ViewTask> viewTasks) {
		this.viewTasks = viewTasks;
	}

}

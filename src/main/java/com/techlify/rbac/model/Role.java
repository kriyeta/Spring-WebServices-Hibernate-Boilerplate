package com.techlify.rbac.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
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

	@OneToOne
	@JoinColumn(name = "id_userid")
	private User user;

	@ManyToMany
	@JoinTable(name = "tm_role_task", joinColumns = { @JoinColumn(name = "id_roleid", referencedColumnName = "id_roleid") }, inverseJoinColumns = { @JoinColumn(name = "id_taskid", referencedColumnName = "id_taskid") })
	private List<Task> tasks;

	public List<Task> getTasks() {
		return tasks;
	}

	public void setTsaks(List<Task> tasks) {
		this.tasks = tasks;
	}

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

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}

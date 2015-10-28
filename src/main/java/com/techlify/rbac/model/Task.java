package com.techlify.rbac.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author kamal
 *
 */
@Entity
@Table(name = "t_mis_task")
public class Task {

	@Id
	@Column(name = "id_taskid")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long taskId;

	@Column(name = "tx_name", length = 50)
	private String name;

	@Column(name = "tx_display_name", length = 50)
	private String displayName;
	
	@Column(name = "tx_default_display_name", length = 50, nullable=true)
	private String defaultDisplayName;

	@Column(name = "tx_group", length = 50)
	private String group;

	@Column(name = "tx_url", length = 50)
	private String url;
	
	@Column(name = "tx_method", length = 20)
	private String method;
	
	@Column(name = "bool_is_dispay")
	private boolean isDispay;
	
	public long getTaskId() {
		return taskId;
	}

	public void setTaskId(long taskId) {
		this.taskId = taskId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	public String getGroup() {
		return group;
	}

	public void setGroup(String group) {
		this.group = group;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getMethod() {
		return method;
	}

	public void setMethod(String method) {
		this.method = method;
	}

	public String getDefaultDisplayName() {
		return defaultDisplayName;
	}

	public void setDefaultDisplayName(String defaultDisplayName) {
		this.defaultDisplayName = defaultDisplayName;
	}

	public boolean isDispay() {
		return isDispay;
	}

	public void setDispay(boolean isDispay) {
		this.isDispay = isDispay;
	}

}

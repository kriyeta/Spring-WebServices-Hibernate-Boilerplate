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
@Table(name = "t_mis_view_task")
public class ViewTask {

	@Id
	@Column(name = "id_view_taskid")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long viewTaskId;

	@Column(name = "tx_name", length = 50)
	private String name;

	@Column(name = "tx_group", length = 50)
	private String group;

	@Column(name = "tx_sub_group", length = 50)
	private String subGroup;
	
	@Column(name = "tx_fxml_url", length = 250)
	private String fxmlUrl;
	
	@Column(name = "bool_is_dispay")
	private boolean isDispay=true;
	
	@Column(name = "bool_is_developer_task")
	private boolean isDeveloperTask=false;

	public long getViewTaskId() {
		return viewTaskId;
	}

	public void setViewTaskId(long viewTaskId) {
		this.viewTaskId = viewTaskId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGroup() {
		return group;
	}

	public void setGroup(String group) {
		this.group = group;
	}

	public String getSubGroup() {
		return subGroup;
	}

	public void setSubGroup(String subGroup) {
		this.subGroup = subGroup;
	}

	public String getFxmlUrl() {
		return fxmlUrl;
	}

	public void setFxmlUrl(String fxmlUrl) {
		this.fxmlUrl = fxmlUrl;
	}

	public boolean isDispay() {
		return isDispay;
	}

	public void setDispay(boolean isDispay) {
		this.isDispay = isDispay;
	}

	public boolean isDeveloperTask() {
		return isDeveloperTask;
	}

	public void setDeveloperTask(boolean isDeveloperTask) {
		this.isDeveloperTask = isDeveloperTask;
	}

}

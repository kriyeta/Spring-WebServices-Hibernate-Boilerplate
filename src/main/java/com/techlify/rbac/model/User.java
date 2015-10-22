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
@Table(name = "t_mis_user")
public class User {

	@Id
	@Column(name = "id_userid")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long userId;

	@Column(name = "tx_user_name", length = 50, unique = true)
	private String userName;

	@Column(name = "tx_name", length = 50, nullable = false)
	private String name;

	@Column(name = "tx_empid", length = 20, unique = true)
	private String empId;

	@Column(name = "tx_designation", length = 50, nullable = true)
	private String designation;

	@Column(name = "tx_department", length = 50, nullable = true)
	private String department;

	@Column(name = "tx_password", length = 50, nullable = false)
	private String password;

	@Column(name = "tx_mobile", length = 20, nullable = true)
	private String mobile;

	@Column(name = "tx_email", length = 100, nullable = true)
	private String email;

	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(name = "tm_user_role", joinColumns = { @JoinColumn(name = "id_userid", referencedColumnName = "id_userid") }, inverseJoinColumns = { @JoinColumn(name = "id_roleid", referencedColumnName = "id_roleid") })
	private List<Role> roles;
	
	@Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (userId == null || obj == null || getClass() != obj.getClass())
            return false;
        User that = (User) obj;
        return userId.equals(that.userId);
    }
    @Override
    public int hashCode() {
        return userId == null ? 0 : userId.hashCode();
    }
	
	
	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmpId() {
		return empId;
	}

	public void setEmpId(String empId) {
		this.empId = empId;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

}

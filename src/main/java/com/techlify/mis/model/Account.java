package com.techlify.mis.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "t_account")
public class Account {

	@Id
	@Column(name = "id_accountid")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "tx_account_username", length = 60, unique = true)
	private String username;

	@Column(name = "tx_account_password", length = 60)
	private String password;

	public Account() {
	}

	public Account(String username, String password) {
		this.username = username;
		this.password = password;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
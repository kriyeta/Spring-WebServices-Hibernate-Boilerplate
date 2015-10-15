package com.techlify.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.techlify.model.Account;

@Transactional
public interface AccountRepository extends JpaRepository<Account, String> {

	public Account findByUsername(String username);

}
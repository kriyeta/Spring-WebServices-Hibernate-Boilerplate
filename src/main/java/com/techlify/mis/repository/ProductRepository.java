package com.techlify.mis.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.techlify.mis.model.Product;

@Transactional
public interface ProductRepository extends JpaRepository<Product, Long> {
	public Product findByName(String name);

}

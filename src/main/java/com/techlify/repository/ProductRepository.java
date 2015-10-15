package com.techlify.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.techlify.model.Product;

@Transactional
public interface ProductRepository extends JpaRepository<Product, Long> {
	public Product findByName(String name);

}

package com.techlify.mis.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.techlify.mis.model.Product;
import com.techlify.mis.repository.ProductRepository;

@RestController
public class ProductController {
	@Autowired
	private ProductRepository productDao;

	@RequestMapping(value = { "/product/save" }, method = RequestMethod.POST)
	public Product saveProduct(@RequestBody Product product) {
		return productDao.save(product);
	}

	@RequestMapping(value = { "/product/all" }, method = RequestMethod.GET)
	public List<Product> getAllProducts() {
		List<Product> products = (List<Product>) productDao.findAll();
		return products;
	}
	
	@RequestMapping(value = { "/product/get-by-name" }, method = RequestMethod.GET)
	public Product getProductByName(String name) {
		Product product	=	productDao.findByName(name);
		return product;
	}
	
	@RequestMapping(value = { "/product/get" }, method = RequestMethod.GET)
	public Product getProductByName(long id) {
		Product product	=	productDao.findOne(id);
		return product;
	}
	
	
	@RequestMapping(value = { "/product/delete-all" }, method = RequestMethod.PUT)
	public String removeAllProducts() {
		productDao.deleteAll();
		return "All products deleted";
	}
	
	@RequestMapping(value = { "/product/delete" }, method = RequestMethod.PUT)
	public String removeProduct(long id) {
		productDao.delete(id);
		return "Product deleted with ID: "+id;
	}
}
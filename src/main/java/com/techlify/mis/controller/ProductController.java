package com.techlify.mis.controller;

import java.util.List;

import org.jsondoc.core.annotation.Api;
import org.jsondoc.core.annotation.ApiBodyObject;
import org.jsondoc.core.annotation.ApiMethod;
import org.jsondoc.core.annotation.ApiPathParam;
import org.jsondoc.core.annotation.ApiQueryParam;
import org.jsondoc.core.annotation.ApiResponseObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.techlify.commons.Constants;
import com.techlify.mis.model.Product;
import com.techlify.mis.repository.ProductRepository;
import com.techlify.rbac.commons.Result;

@RestController
@RequestMapping(value = "/product")
@Api(description = "The product controller", name = "Product services")
public class ProductController {
	@Autowired
	private ProductRepository productRepository;

	/*
	 * GET requests
	 */
	@ApiMethod(id = Constants.PRODUCT_GROUP + "_FIND_ALL", description = "VIEW ALL PRODUCT")
	@RequestMapping(value = { "/all" }, method = RequestMethod.GET)
	public @ApiResponseObject @ResponseBody Result getAllProducts() {
		List<Product> products = (List<Product>) productRepository.findAll();
		return new Result("sucess",products);
	}

	@ApiMethod(id = Constants.PRODUCT_GROUP + "_FIND_BY_NAME", description = "VIEW PRODUCT BY NAME")
	@RequestMapping(value = { "/" }, method = RequestMethod.GET)
	public @ApiResponseObject @ResponseBody List<Product> getProductByName(
			@ApiQueryParam(name = "name", description = "The name of the product") @RequestParam("name") String name) {
		List<Product> products = productRepository.findByName(name);
		return products;
	}

	@ApiMethod(id = Constants.PRODUCT_GROUP + "_FIND_BY_ID", description = "VIEW PRODUCT BY ID")
	@RequestMapping(value = { "/{id}" }, method = RequestMethod.GET)
	public @ApiResponseObject @ResponseBody Product getProductById(
			@ApiPathParam(name = "id", description = "The id of the product") @PathVariable("id") Long id) {
		Product product = productRepository.findOne(id);
		return product;
	}

	/*
	 * POST requests
	 */
	@ApiMethod(id = Constants.PRODUCT_GROUP + "_ADD", description = "ADD PRODUCT")
	@RequestMapping(value = { "/add" }, method = RequestMethod.POST)
	public @ApiResponseObject @ResponseBody Product saveProduct(
			@ApiBodyObject @RequestBody Product product) {
		return productRepository.save(product);
	}

	/*
	 * PUT requests
	 */
	@ApiMethod(id = Constants.PRODUCT_GROUP + "_UPDATE_BY_ID", description = "UPDATE PRODUCT")
	@RequestMapping(value = { "/{id}" }, method = RequestMethod.PUT)
	public @ApiResponseObject @ResponseBody Product updateProduct(@ApiPathParam(name = "id", description = "The id of the product") @PathVariable("id") Long id,
			@ApiBodyObject @RequestBody Product product) {
		product.setId(productRepository.findOne(id).getId());
		return productRepository.saveAndFlush(product);
	}

	/*
	 * DELETE requests
	 */
	@ApiMethod(id = Constants.PRODUCT_GROUP + "_DELETE_ALL", description = "DELETE ALL PRODUCT")
	@RequestMapping(value = { "/all" }, method = RequestMethod.DELETE)
	public @ApiResponseObject @ResponseBody String removeAllProducts() {
		productRepository.deleteAll();
		return "All products deleted";
	}

	@ApiMethod(id = Constants.PRODUCT_GROUP + "_DELETE_BY_ID", description = "DELETE PRODUCT")
	@RequestMapping(value = { "/{id}" }, method = RequestMethod.DELETE)
	public @ApiResponseObject @ResponseBody String removeProduct(
			@ApiPathParam(name = "id", description = "The id of the product") @PathVariable("id") Long id) {
		productRepository.delete(id);
		return "Product deleted with ID: " + id;
	}

}
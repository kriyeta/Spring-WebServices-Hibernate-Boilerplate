package com.techlify.mis.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "t_product")
public class Product {

	@Id
	@Column(name = "id_productid")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column(name = "tx_product_name", length = 50)
	private String name;

	@Column(name = "n_price", length = 10, nullable = true)
	private long price;

	@Column(name = "n_quantity", length = 3, nullable = true)
	private long quantity;

	@Column(name = "tx_description", length = 150, nullable = true)
	private String description;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getPrice() {
		return price;
	}

	public void setPrice(long price) {
		this.price = price;
	}

	public long getQuantity() {
		return quantity;
	}

	public void setQuantity(long quantity) {
		this.quantity = quantity;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
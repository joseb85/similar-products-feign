package com.josecastillon.similarproducts.app.entities;

import java.io.Serializable;

public class Product implements Serializable {

	private static final long serialVersionUID = 8113172932139605615L;
	private String id;
	private String name;
	private Double price;
	private Boolean availability;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Boolean getAvailability() {
		return availability;
	}

	public void setAvailability(Boolean availability) {
		this.availability = availability;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", price=" + price + ", availability=" + availability + "]";
	}

}

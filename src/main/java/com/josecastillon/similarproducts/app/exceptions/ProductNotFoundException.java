package com.josecastillon.similarproducts.app.exceptions;

public class ProductNotFoundException extends Exception {

	private static final long serialVersionUID = -6210613519139947797L;

	public ProductNotFoundException() {
		super("Product not found");
	}

}

package com.josecastillon.similarproducts.app.services;

import java.util.List;

import com.josecastillon.similarproducts.app.entities.Product;
import com.josecastillon.similarproducts.app.exceptions.ProductNotFoundException;

public interface SimilarProductsService {
	
	public List<Product> findSimilarById(String id) throws ProductNotFoundException;
	
}

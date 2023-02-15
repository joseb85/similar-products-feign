package com.josecastillon.similarproducts.app.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.josecastillon.similarproducts.app.entities.Product;
import com.josecastillon.similarproducts.app.exceptions.ProductNotFoundException;
import com.josecastillon.similarproducts.app.services.SimilarProductsService;

@Controller
@RequestMapping("/product")
public class SimilarProductsController {
	
	@Autowired
	private SimilarProductsService similarProductsService;

	/**
	 * Devuelve los productos similares a otro
	 * @param id Id del producto a buscar sus similares
	 * @return
	 */
	@GetMapping(path = "/{id}/similar")
	public ResponseEntity<?> findSimilarById(@PathVariable String id) {
		try {
			List<Product> products = similarProductsService.findSimilarById(id);
			return ResponseEntity.ok().body(products);
		} catch (ProductNotFoundException e) {
//			throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
			return ResponseEntity
		            .status(HttpStatus.NOT_FOUND)
		            .body(e.getMessage());
		}
	}
	
}

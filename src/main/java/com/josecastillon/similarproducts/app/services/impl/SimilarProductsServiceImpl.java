package com.josecastillon.similarproducts.app.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.josecastillon.similarproducts.app.consumers.ProductsClient;
import com.josecastillon.similarproducts.app.entities.Product;
import com.josecastillon.similarproducts.app.exceptions.ProductNotFoundException;
import com.josecastillon.similarproducts.app.services.SimilarProductsService;

import feign.FeignException;

@Service
public class SimilarProductsServiceImpl implements SimilarProductsService {
	
	private static final Logger log = LoggerFactory.getLogger(SimilarProductsServiceImpl.class);

	@Autowired
	private ProductsClient productsClient;
	
	/**
	 * Recupera los productos similares a un producto
	 * @param id Id del producto a buscar
	 * @throws ProductNotFoundException En caso de que el producto original no exista
	 */
	@Override
	public List<Product> findSimilarById(String id) throws ProductNotFoundException {
		List<Product> similar = new ArrayList<>();
		
		List<String> similarIds = findListIdSimilarById(id);
		
		for (String similarId : similarIds) {
			Product p = this.findById(similarId);
			if (p != null)
				similar.add(p);
		}		
		
		return similar;
	}
	
	/**
	 * Recupera los ids de los productos similares a un producto
	 * @param id Id del producto original
	 * @return Lista de ids de los productos similares
	 * @throws ProductNotFoundException En caso de que el producto original no exista
	 */
	private List<String> findListIdSimilarById(String id) throws ProductNotFoundException {
		List<String> similarIds = new ArrayList<>();
		try {
			similarIds = this.productsClient.findListIdSimilarById(id);
		} catch (FeignException e) {
			log.error(e.getMessage());			
		}
		
		if (similarIds.isEmpty() && this.findById(id) == null)
			throw new ProductNotFoundException();
		
		return similarIds;
	}
	
	/**
	 * Recupera un producto según su id
	 * @param id Id del producto
	 * @return Producto. En caso de que no exista devuelve nulo
	 */
	private Product findById(String id) {
		try {
			return this.productsClient.findById(id);
		} catch (FeignException e) {
			log.error(e.getMessage());
		}
		return null;
	}

}

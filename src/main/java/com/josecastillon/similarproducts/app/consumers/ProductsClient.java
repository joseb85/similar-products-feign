package com.josecastillon.similarproducts.app.consumers;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.josecastillon.similarproducts.app.entities.Product;

@FeignClient(name="productsClient", url="http://localhost:3001/product")
public interface ProductsClient {

	@GetMapping("/{id}/similarids")
    public List<String> findListIdSimilarById(@PathVariable("id") String id);

    @GetMapping("/{id}")
    public Product findById(@PathVariable("id") String id);
}

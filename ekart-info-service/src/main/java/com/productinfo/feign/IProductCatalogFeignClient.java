package com.productinfo.feign;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.productinfo.model.Product;

// this is the client for catalog-service
// this is a declarative client
// the implementation will be created during the runtime
//pass the name of the service to which you want to connect

@FeignClient(name = "product-catalog")
public interface IProductCatalogFeignClient {
	
	// add methods to connect to the restend points of catalog-service
	//add the same url mapping.
//	 http://localhost:8081/catalog-service/v1/products/productId/1
	@GetMapping("/catalog-service/v1/products/productId/{productId}")
	ResponseEntity<Product> getById(@PathVariable int productId) ;
	
//	http://localhost:8081/catalog-service/v1/products
	@GetMapping("/catalog-service/v1/products")
	ResponseEntity<List<Product>> getAll();
	
//	http://localhost:8081/catalog-service/v1/products/brand/Samsung
	@GetMapping("/catalog-service/v1/products/brand/{brand}")
	ResponseEntity<List<Product>> getByBrand(@PathVariable String brand) ;
	
//	http://localhost:8081/catalog-service/v1/products/category?category=electronics
	@GetMapping("/catalog-service/v1/products/category")
	ResponseEntity<List<Product>> getByCategory(@RequestParam String category) ;
	
//	http://localhost:8081/catalog-service/v1/products/category/Electronics/price/20000
	@GetMapping("/products/category/{category}/price/{price}")
	List<Product> getByCatLessPrice(@PathVariable String category, double price) ;
	
	
	

}

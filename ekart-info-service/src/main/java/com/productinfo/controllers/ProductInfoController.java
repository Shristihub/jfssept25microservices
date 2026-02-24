package com.productinfo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.productinfo.model.Product;
import com.productinfo.service.IProductInfoService;



@RestController
@RequestMapping("/info-service/v1")
public class ProductInfoController {
	
	@Autowired
	private IProductInfoService infoService;
	//http://localhost:8082/info-service/v1/product-info
	@GetMapping("/product-info")
	ResponseEntity<List<Product>> viewAllProducts(){
		return ResponseEntity.ok(infoService.getAllProducts());
	}
	@GetMapping("/product-info/productId/{productId}")
	ResponseEntity<Product> viewProductById(@PathVariable int productId) {
		return ResponseEntity.ok(infoService.getById(productId));
	}
	@GetMapping("/product-info/brand/{brand}")
	ResponseEntity<List<Product>> viewProductsByBrand(@PathVariable String brand) {
		return ResponseEntity.ok(infoService.getProductsByBrand(brand));
	}
	@GetMapping("/product-info/category/{category}")
	ResponseEntity<List<Product>> viewProductsByCategory(@PathVariable String category) {
		return ResponseEntity.ok(infoService.getProductsByCategory(category));
	}
	@GetMapping("/product-info/category/{category}/price/{price}")
	ResponseEntity<List<Product>> viewProductsByCatLessPrice(@PathVariable String category, @PathVariable double price) {
		return ResponseEntity.ok(infoService.getProductsByCatLessPrice(category, price));
}
}

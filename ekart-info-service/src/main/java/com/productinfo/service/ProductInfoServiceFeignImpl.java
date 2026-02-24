package com.productinfo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.productinfo.feign.IProductCatalogFeignClient;
import com.productinfo.model.Product;

//@Service
public class ProductInfoServiceFeignImpl implements IProductInfoService{
	
	@Autowired
	IProductCatalogFeignClient feignClient;

	@Override
	public List<Product> getAllProducts() {
		//the method returns ResponseEntity. get the body
		return feignClient.getAll().getBody();
	}

	@Override
	public List<Product> getProductsByBrand(String brand) {
		return feignClient.getByBrand(brand).getBody();
	}

	@Override
	public List<Product> getProductsByCategory(String category) {
		return feignClient.getByCategory(category).getBody();
	}

	@Override
	public List<Product> getProductsByCatLessPrice(String category, double price) {
		return feignClient.getByCatLessPrice(category, price);
	}

	@Override
	public Product getById(int productId) {
		return feignClient.getById(productId).getBody();
	}

}

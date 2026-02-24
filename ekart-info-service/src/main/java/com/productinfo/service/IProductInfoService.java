package com.productinfo.service;

import java.util.List;

import com.productinfo.model.Product;

public interface IProductInfoService {

	List<Product> getAllProducts();
	List<Product> getProductsByBrand(String brand);
	List<Product> getProductsByCategory(String category);
	List<Product> getProductsByCatLessPrice(String category, double price);
	Product getById(int productId);

}

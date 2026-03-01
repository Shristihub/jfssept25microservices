package com.productcart.service;

import com.productcart.model.CartDto;

public interface ICartService {

	void addToCart(int userId,int productId,int quantity);
	
	CartDto viewCart(int userId);
}

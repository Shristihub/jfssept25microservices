package com.productinfo.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Product {

	private String productName;
	private Integer productId;
	private double price;
	private Features features;
	private List<Offers> offers;
	private Brand brand;
	private List<Category> categories;
	private List<String> paymentModes; // COD,UPI,CREDITCARD,DEBITCARD
	private List<String> deliveryTypes; // standard, prime,free
}

package com.productinfo.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Category {
	private Integer categoryId;
	private String categoryName;
	@JsonIgnore
	private List<Product> products;
}

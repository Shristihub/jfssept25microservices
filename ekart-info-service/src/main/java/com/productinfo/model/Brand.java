package com.productinfo.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString(exclude = "products")
public class Brand {

	private String brandName;
	private Integer brandId;
	@JsonIgnore
	private List<Product> products;
}

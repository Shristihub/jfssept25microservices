package com.productinfo.model;

import com.productinfo.model.enums.OffersType;

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
public class Offers {
	private OffersType offersType; //cashback, bankoffer, partneroffer
	private Integer offersId;
	private String description;

}










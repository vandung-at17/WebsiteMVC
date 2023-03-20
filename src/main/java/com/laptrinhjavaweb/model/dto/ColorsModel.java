package com.laptrinhjavaweb.model.dto;

import com.laptrinhjavaweb.entity.ProductsEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ColorsModel {
	private Long id;
	private ProductsEntity productsEntity;
	private String name;
	private String code;
	private String img;
}

package com.laptrinhjavaweb.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CartModel {
	private int quanty; //số lượng
	private double totalPrice; //Tổng Giá
	private ProductsModel product;
}

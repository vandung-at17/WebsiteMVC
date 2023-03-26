package com.laptrinhjavaweb.dao;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.laptrinhjavaweb.model.dto.CartDto;
import com.laptrinhjavaweb.model.dto.ProductsDto;
import com.laptrinhjavaweb.service.IProductsService;

@Repository
public class CartDao {

	@Autowired
	private IProductsService productsService;

	// Thêm hàng vào trong giỏ hàng
	public HashMap<Long, CartDto> AddCart(long id, HashMap<Long, CartDto> cart) {
		CartDto itemCart = new CartDto();
		ProductsDto product = productsService.getProductByID(id);
		if (product != null && cart.containsKey(id)) {
			itemCart = cart.get(id);
			itemCart.setQuanty(itemCart.getQuanty() +1);
			itemCart.setTotalPrice(itemCart.getQuanty()* itemCart.getProduct().getPrice());
		}else {
			itemCart.setProduct(product);
			itemCart.setQuanty(1);
			//double totalPrice = product.getPrice() * itemCart.getQuanty();
			itemCart.setTotalPrice(product.getPrice());
		}
		cart.put(id, itemCart);
		return cart;
	}

	//
	public HashMap<Long, CartDto> EditCart(long id, int quanty, HashMap<Long, CartDto> cart) {
		if (cart == null) {
			return cart;
		}
		CartDto itemCart = new CartDto();
		if (cart.containsKey(id)) {
			itemCart = cart.get(id);
			itemCart.setQuanty(quanty);
			itemCart.setTotalPrice(itemCart.getQuanty() * itemCart.getProduct().getPrice());
		}
		cart.put(id, itemCart);
		return cart;
	}

	public HashMap<Long, CartDto> DeleteCart(long id, HashMap<Long, CartDto> cart){
		if (cart == null) {
			return cart;
		}
		if (cart.containsKey(id)) {
			cart.remove(id);
		}
		return cart;
	}
	
	public int TotalQuanty( HashMap<Long, CartDto> cart){
		int totalQuanty = 0;
		for(Map.Entry<Long, CartDto> itemCart : cart.entrySet()) {
			totalQuanty += itemCart.getValue().getQuanty();
		}
		return totalQuanty;
	}
	
	public double totalAllPrice(HashMap<Long, CartDto> cart) {
		double totalAllPrice = 0;
		for(Map.Entry<Long, CartDto> itemCart : cart.entrySet()) {
			totalAllPrice += itemCart.getValue().getTotalPrice();
		}
		return totalAllPrice;
	}
}

package com.laptrinhjavaweb.dao;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.laptrinhjavaweb.model.dto.CartModel;
import com.laptrinhjavaweb.model.dto.ProductsModel;
import com.laptrinhjavaweb.service.IProductsService;

@Repository
public class CartDao {

	@Autowired
	private IProductsService productsService;

	// Thêm hàng vào trong giỏ hàng
	public HashMap<Long, CartModel> AddCart(long id, HashMap<Long, CartModel> cart) {
		CartModel itemCart = new CartModel();
		ProductsModel product = productsService.getProductByID(id);
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
	public HashMap<Long, CartModel> EditCart(long id, int quanty, HashMap<Long, CartModel> cart) {
		if (cart == null) {
			return cart;
		}
		CartModel itemCart = new CartModel();
		if (cart.containsKey(id)) {
			itemCart = cart.get(id);
			itemCart.setQuanty(quanty);
			itemCart.setTotalPrice(itemCart.getQuanty() * itemCart.getProduct().getPrice());
		}
		cart.put(id, itemCart);
		return cart;
	}

	public HashMap<Long, CartModel> DeleteCart(long id, HashMap<Long, CartModel> cart){
		if (cart == null) {
			return cart;
		}
		if (cart.containsKey(id)) {
			cart.remove(id);
		}
		return cart;
	}
	
	public int TotalQuanty( HashMap<Long, CartModel> cart){
		int totalQuanty = 0;
		for(Map.Entry<Long, CartModel> itemCart : cart.entrySet()) {
			totalQuanty += itemCart.getValue().getQuanty();
		}
		return totalQuanty;
	}
	
	public double totalAllPrice(HashMap<Long, CartModel> cart) {
		double totalAllPrice = 0;
		for(Map.Entry<Long, CartModel> itemCart : cart.entrySet()) {
			totalAllPrice += itemCart.getValue().getTotalPrice();
		}
		return totalAllPrice;
	}
}

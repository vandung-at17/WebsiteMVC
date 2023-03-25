package com.laptrinhjavaweb.service;

import java.util.HashMap;

import com.laptrinhjavaweb.model.dto.CartModel;

public interface ICartService {
	public HashMap<Long, CartModel> AddCart(long id, HashMap<Long, CartModel> cart);
	public HashMap<Long, CartModel> EditCart(long id, int quanty, HashMap<Long, CartModel> cart);
	public HashMap<Long, CartModel> DeleteCart(long id, HashMap<Long, CartModel> cart);
	public int TotalQuanty( HashMap<Long, CartModel> cart);
	public double totalAllPrice(HashMap<Long, CartModel> cart);
}

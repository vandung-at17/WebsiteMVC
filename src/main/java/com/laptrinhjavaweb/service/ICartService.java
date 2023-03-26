package com.laptrinhjavaweb.service;

import java.util.HashMap;

import com.laptrinhjavaweb.model.dto.CartDto;

public interface ICartService {
	public HashMap<Long, CartDto> AddCart(long id, HashMap<Long, CartDto> cart);
	public HashMap<Long, CartDto> EditCart(long id, int quanty, HashMap<Long, CartDto> cart);
	public HashMap<Long, CartDto> DeleteCart(long id, HashMap<Long, CartDto> cart);
	public int TotalQuanty( HashMap<Long, CartDto> cart);
	public double totalAllPrice(HashMap<Long, CartDto> cart);
}

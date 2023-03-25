package com.laptrinhjavaweb.service.impl;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.laptrinhjavaweb.dao.CartDao;
import com.laptrinhjavaweb.model.dto.CartModel;
import com.laptrinhjavaweb.service.ICartService;

@Service
public class CartService implements ICartService{

	@Autowired
	private CartDao cartDao = new CartDao();
	
	@Override
	public HashMap<Long, CartModel> AddCart(long id, HashMap<Long, CartModel> cart) {
		// TODO Auto-generated method stub
		return cartDao.AddCart(id, cart);
	}

	@Override
	public HashMap<Long, CartModel> EditCart(long id, int quanty, HashMap<Long, CartModel> cart) {
		// TODO Auto-generated method stub
		return cartDao.EditCart(id, quanty, cart);
	}

	@Override
	public HashMap<Long, CartModel> DeleteCart(long id, HashMap<Long, CartModel> cart) {
		// TODO Auto-generated method stub
		return cartDao.DeleteCart(id, cart);
	}

	@Override
	public int TotalQuanty(HashMap<Long, CartModel> cart) {
		// TODO Auto-generated method stub
		return cartDao.TotalQuanty(cart);
	}

	@Override
	public double totalAllPrice(HashMap<Long, CartModel> cart) {
		// TODO Auto-generated method stub
		return cartDao.totalAllPrice(cart);
	}

}

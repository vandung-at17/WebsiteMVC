package com.laptrinhjavaweb.service;

import java.util.HashMap;

import com.laptrinhjavaweb.model.dto.CartDto;
public interface IBillDetailService {
	public void addBillsDetail (HashMap<Long, CartDto> carts);
}

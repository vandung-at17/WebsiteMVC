package com.laptrinhjavaweb.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.laptrinhjavaweb.entity.BillDetailEntity;
import com.laptrinhjavaweb.entity.BillsEntity;
import com.laptrinhjavaweb.entity.ProductsEntity;
import com.laptrinhjavaweb.model.dto.BillDetailDto;
import com.laptrinhjavaweb.model.dto.CartDto;
import com.laptrinhjavaweb.repository.BillDetailRepository;
import com.laptrinhjavaweb.service.IBillDetailService;
import com.laptrinhjavaweb.service.IBillsService;

@Service
public class BillDetailService implements IBillDetailService{

	@Autowired
	private IBillsService billsService;
	
	@Autowired
	private BillDetailRepository billDetailRepository;
	
	@Override
	public void addBillsDetail(HashMap<Long, CartDto> carts) {
		// TODO Auto-generated method stub
		long idBills = billsService.getIDLastBills();
		for (Map.Entry<Long, CartDto> itemCart : carts.entrySet()) {
			BillDetailEntity billDetailEntity = new BillDetailEntity();
			BillsEntity billsEntity = new BillsEntity();
			billsEntity.setId(idBills);
			billDetailEntity.setBillsEntity(billsEntity);
			ProductsEntity productsEntity = new ProductsEntity();
			productsEntity.setId(itemCart.getValue().getProduct().getId());
			billDetailEntity.setProduct(productsEntity);
			billDetailEntity.setQuaty(itemCart.getValue().getQuanty());
			billDetailEntity.setTotal(itemCart.getValue().getTotalPrice());
			billDetailRepository.save(billDetailEntity);
		}	
	}
	
}

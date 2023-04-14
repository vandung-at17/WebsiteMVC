package com.laptrinhjavaweb.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.laptrinhjavaweb.entity.BillsEntity;
import com.laptrinhjavaweb.model.dto.BillsDto;
import com.laptrinhjavaweb.repository.BillsRepository;
import com.laptrinhjavaweb.service.IBillsService;

@Service
public class BillsService implements IBillsService{

	@Autowired
	private BillsRepository billsRepository;
	
	@Override
	@Transactional
	public int addBills(BillsDto billsDto) {
		// TODO Auto-generated method stub
		BillsEntity billsEntity = new BillsEntity();
		billsEntity.setAddress(billsDto.getAddress());
		billsEntity.setDisplay_name(billsDto.getDisplay_name());
		billsEntity.setEmail(billsDto.getEmail());
		billsEntity.setNote(billsDto.getNote());
		billsEntity.setPhone(billsDto.getPhone());
		billsEntity.setQuanty(billsDto.getQuanty());
		billsEntity.setTotal(billsDto.getTotal());
		try {
			billsEntity = billsRepository.save(billsEntity);
			return 1;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Lỗi ở phần Bill");
			return 0;
		}
	}

	@Override
	public long getIDLastBills() {
		// TODO Auto-generated method stub
		long id = billsRepository.getIDLastBills();
		return id;
	}
}

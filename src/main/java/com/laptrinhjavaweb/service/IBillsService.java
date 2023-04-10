package com.laptrinhjavaweb.service;

import com.laptrinhjavaweb.model.dto.BillsDto;

public interface IBillsService {
	public int addBills(BillsDto billsDto);
	public long getIDLastBills();
}

package com.laptrinhjavaweb.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
// Thông tin người mua hàng
public class BillsDto {
	private String email;
	private String phone;
	private String display_name;
	private String address;
	private double total;
	private int quanty;
	private String note;
}

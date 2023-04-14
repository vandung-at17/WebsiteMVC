package com.laptrinhjavaweb.model.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {

	private Long id;
	private Date createdDate;
	private Date modifiedDate;
	private String password;
	private String display_name;
	private String address;
	private String email;
}

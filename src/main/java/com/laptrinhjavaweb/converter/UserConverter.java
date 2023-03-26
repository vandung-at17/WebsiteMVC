package com.laptrinhjavaweb.converter;

import com.laptrinhjavaweb.entity.UserEntity;
import com.laptrinhjavaweb.model.dto.UserDto;

public class UserConverter {
	public UserDto toModel (UserEntity userEntity) {
		UserDto userDto = new UserDto();
		userDto.setId(userEntity.getId());
		userDto.setCreatedDate(userEntity.getCreatedDate());
		userDto.setModifiedDate(userEntity.getModifiedDate());
		userDto.setUser(userEntity.getUser());
		userDto.setPassword(userEntity.getPassword());
		userDto.setDisplay_name(userEntity.getDisplay_name());
		userDto.setAddress(userEntity.getAddress());
		userDto.setEmail(userEntity.getEmail());
		return userDto;
	}
}

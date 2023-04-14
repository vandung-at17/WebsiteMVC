package com.laptrinhjavaweb.converter;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Component;

import com.laptrinhjavaweb.entity.UserEntity;
import com.laptrinhjavaweb.model.dto.UserDto;
import com.laptrinhjavaweb.model.request.UserRegisterRequest;
@Component
public class UserConverter {
	public UserDto toModel (UserEntity userEntity) {
		UserDto userDto = new UserDto();
		userDto.setId(userEntity.getId());
		userDto.setCreatedDate(userEntity.getCreatedDate());
		userDto.setModifiedDate(userEntity.getModifiedDate());
		userDto.setPassword(userEntity.getPassword());
		userDto.setDisplay_name(userEntity.getDisplay_name());
		userDto.setAddress(userEntity.getAddress());
		userDto.setEmail(userEntity.getEmail());
		return userDto;
	}
	
	public UserEntity registerToEntity(UserRegisterRequest request) {
		UserEntity userEntity = new UserEntity();
		userEntity.setDisplay_name(request.getFirstName()+request.getLastName());
		userEntity.setPassword(BCrypt.hashpw(request.getPassword(), BCrypt.gensalt(12)));
		//userEntity.setPassword(request.getPassword());
		userEntity.setStatus(1);
		userEntity.setAddress(request.getAddress());
		userEntity.setEmail(request.getEmail());
		return userEntity;
	}
}

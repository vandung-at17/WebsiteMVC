package com.laptrinhjavaweb.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.laptrinhjavaweb.converter.UserConverter;
import com.laptrinhjavaweb.entity.UserEntity;
import com.laptrinhjavaweb.model.dto.UserDto;
import com.laptrinhjavaweb.model.request.UserLoginRequest;
import com.laptrinhjavaweb.model.request.UserRegisterRequest;
import com.laptrinhjavaweb.repository.UserRepository;
import com.laptrinhjavaweb.service.IUserService;
@Service
public class UserService implements  IUserService{
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private UserConverter userConverter;

	@Override
	@Transactional
	public UserRegisterRequest insert(UserRegisterRequest registerRequest) {
		// TODO Auto-generated method stub
		UserEntity userEntity = userConverter.registerToEntity(registerRequest);
		userEntity = userRepository.save(userEntity);
		return registerRequest;
	}

	@Override
	public UserDto CheckAccountLogin(UserLoginRequest userLoginRequest) {
		// TODO Auto-generated method stub
		return null;
	}
	
}

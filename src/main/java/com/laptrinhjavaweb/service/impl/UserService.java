package com.laptrinhjavaweb.service.impl;

import org.mindrot.jbcrypt.BCrypt;
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

	@Override
	public UserDto findOneByEmail(String email) {
		// TODO Auto-generated method stub
		UserEntity userEntity = userRepository.findOneByEmailAndStatus(email, 1);
		UserDto userDto = userConverter.toModel(userEntity);
		return userDto;
	}

	@Override
	@Transactional
	public void updatePassWordNew(String passwordNew, String gmail) {
		// TODO Auto-generated method stub
		String passWord = BCrypt.hashpw(passwordNew, BCrypt.gensalt(12));
		UserEntity userEntity = userRepository.findOneByEmailAndStatus(gmail, 1);
	    userRepository.updatePassWordOfEmail(passWord, userEntity.getId());
	}
	
}

package com.laptrinhjavaweb.service;

import com.laptrinhjavaweb.model.dto.UserDto;
import com.laptrinhjavaweb.model.request.UserLoginRequest;
import com.laptrinhjavaweb.model.request.UserRegisterRequest;

public interface IUserService {
	public UserRegisterRequest insert(UserRegisterRequest registerRequest);
	public UserDto CheckAccountLogin (UserLoginRequest userLoginRequest);
}

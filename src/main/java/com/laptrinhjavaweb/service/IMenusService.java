package com.laptrinhjavaweb.service;

import java.util.List;

import com.laptrinhjavaweb.model.dto.MenusDto;

public interface IMenusService {
	List<MenusDto> findAll ();
}

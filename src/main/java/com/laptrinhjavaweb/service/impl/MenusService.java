package com.laptrinhjavaweb.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.laptrinhjavaweb.converter.MenusConverter;
import com.laptrinhjavaweb.entity.MenusEntity;
import com.laptrinhjavaweb.model.dto.MenusModel;
import com.laptrinhjavaweb.repository.MenusRepository;
import com.laptrinhjavaweb.service.IMenusService;

@Service
public class MenusService implements IMenusService{

	@Autowired
	private MenusRepository menusRepository;
	
	@Autowired
	private MenusConverter menusConverter;
	
	@Override
	public List<MenusModel> findAll() {
		// TODO Auto-generated method stub
		List<MenusModel> menusModels = new ArrayList<>();
		List<MenusEntity> menusEntities = menusRepository.findAll();
		for (MenusEntity menusEntity : menusEntities) {
			MenusModel menusModel = menusConverter.toModel(menusEntity);
			menusModels.add(menusModel);
		}
		return menusModels;
	}
	
}

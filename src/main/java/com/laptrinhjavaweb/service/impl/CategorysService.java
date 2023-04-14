package com.laptrinhjavaweb.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.laptrinhjavaweb.converter.CategorysConverter;
import com.laptrinhjavaweb.entity.CategorysEntity;
import com.laptrinhjavaweb.model.dto.CategorysDto;
import com.laptrinhjavaweb.repository.CategorysRepository;
import com.laptrinhjavaweb.service.ICategorysService;

@Service
public class CategorysService implements ICategorysService{

	@Autowired
	private CategorysRepository categorysRepository;
	
	@Autowired
	private CategorysConverter categorysConverter;
	
	@Override
	public List<CategorysDto> findAll() {
		// TODO Auto-generated method stub
		List<CategorysDto> categorysModels = new ArrayList<>();
		List<CategorysEntity> categorysEntities = categorysRepository.findAll();
		for (CategorysEntity categorysEntity : categorysEntities) {
			CategorysDto categorysModel = categorysConverter.toModel(categorysEntity);
			categorysModels.add(categorysModel);
		}
		return categorysModels;
	}

}

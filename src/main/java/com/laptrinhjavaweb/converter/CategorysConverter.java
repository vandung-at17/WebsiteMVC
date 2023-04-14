package com.laptrinhjavaweb.converter;

import org.springframework.stereotype.Component;

import com.laptrinhjavaweb.entity.CategorysEntity;
import com.laptrinhjavaweb.model.dto.CategorysDto;

@Component
public class CategorysConverter {
	public CategorysDto toModel (CategorysEntity categorysEntity) {
		CategorysDto categorysModel = new CategorysDto();
		categorysModel.setId(categorysEntity.getId());
		categorysModel.setName(categorysEntity.getName());
		categorysModel.setDescription(categorysEntity.getDescription());
		return categorysModel;
	}
}

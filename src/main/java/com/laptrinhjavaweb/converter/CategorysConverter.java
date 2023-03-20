package com.laptrinhjavaweb.converter;

import org.springframework.stereotype.Component;

import com.laptrinhjavaweb.entity.CategorysEntity;
import com.laptrinhjavaweb.model.dto.CategorysModel;

@Component
public class CategorysConverter {
	public CategorysModel toModel (CategorysEntity categorysEntity) {
		CategorysModel categorysModel = new CategorysModel();
		categorysModel.setId(categorysEntity.getId());
		categorysModel.setName(categorysEntity.getName());
		categorysModel.setDescription(categorysEntity.getDescription());
		return categorysModel;
	}
}

package com.laptrinhjavaweb.converter;

import org.springframework.stereotype.Component;

import com.laptrinhjavaweb.entity.MenusEntity;
import com.laptrinhjavaweb.model.dto.MenusDto;
@Component
public class MenusConverter {
	public MenusDto toModel (MenusEntity menusEntity) {
		MenusDto menusModel = new MenusDto();
		menusModel.setId(menusEntity.getId());
		menusModel.setName(menusEntity.getName());
		menusModel.setUrl(menusEntity.getUrl());
		return menusModel;
	}
}

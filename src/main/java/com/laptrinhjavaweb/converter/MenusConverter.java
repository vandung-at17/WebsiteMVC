package com.laptrinhjavaweb.converter;

import org.springframework.stereotype.Component;

import com.laptrinhjavaweb.entity.MenusEntity;
import com.laptrinhjavaweb.model.dto.MenusModel;
@Component
public class MenusConverter {
	public MenusModel toModel (MenusEntity menusEntity) {
		MenusModel menusModel = new MenusModel();
		menusModel.setId(menusEntity.getId());
		menusModel.setName(menusEntity.getName());
		menusModel.setUrl(menusEntity.getUrl());
		return menusModel;
	}
}

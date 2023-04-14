package com.laptrinhjavaweb.converter;

import org.springframework.stereotype.Component;

import com.laptrinhjavaweb.entity.ProductsEntity;
import com.laptrinhjavaweb.model.dto.ProductsDto;


@Component
public class ProductsConverter {
	public ProductsDto toModel (ProductsEntity productsEntity) {
		ProductsDto productsModel = new ProductsDto();
		productsModel.setId(productsEntity.getId());
		productsModel.setCreatedDate(productsEntity.getCreatedDate());
		productsModel.setModifiedDate(productsEntity.getModifiedDate());
		productsModel.setName(productsEntity.getName());
		productsModel.setSizes(productsEntity.getSizes());
		productsModel.setPrice(productsEntity.getPrice());
		productsModel.setSale(productsEntity.getSale());
		productsModel.setTitle(productsEntity.getTitle());
		productsModel.setHighlight(productsEntity.getHighlight());
		productsModel.setNewproduct(productsEntity.getNewproduct());
		productsModel.setDetail(productsEntity.getDetail());
		productsModel.setColorsEntities(productsEntity.getColorsEntities());
		productsModel.setCategoryEntity(productsEntity.getCategoryEntity());
		return productsModel;
	}
}

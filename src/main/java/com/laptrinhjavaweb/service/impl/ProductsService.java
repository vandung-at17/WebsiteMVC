package com.laptrinhjavaweb.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.laptrinhjavaweb.converter.ProductsConverter;
import com.laptrinhjavaweb.entity.ColorsEntity;
import com.laptrinhjavaweb.entity.ProductsEntity;
import com.laptrinhjavaweb.model.dto.ProductsModel;
import com.laptrinhjavaweb.model.response.FeaturedProducts;
import com.laptrinhjavaweb.repository.ColorsRepository;
import com.laptrinhjavaweb.repository.ProductsRepository;
import com.laptrinhjavaweb.service.IProductsService;

@Service
public class ProductsService implements IProductsService{

	@Autowired
	private ColorsRepository colorsRepository;
	
	@Autowired
	private ProductsRepository productsRepository;
	
	@Autowired
	private ProductsConverter productsService;
	
	@Override
	public List<FeaturedProducts> findAllFeaturedProducts() {
		// TODO Auto-generated method stub
		List<FeaturedProducts> featuredProducts = new ArrayList<>();
		List<ColorsEntity> colorsEntities = colorsRepository.getFeaturedProductss();
		for (ColorsEntity colorsEntity : colorsEntities) {
			FeaturedProducts products = new FeaturedProducts();
			products.setId_product(colorsEntity.getProductsEntity().getId());
			products.setId_category(colorsEntity.getProductsEntity().getCategoryEntity().getId());
			products.setSizes(colorsEntity.getProductsEntity().getSizes());
			products.setName(colorsEntity.getProductsEntity().getName());
			products.setPrice(colorsEntity.getProductsEntity().getPrice());
			products.setSale(colorsEntity.getProductsEntity().getSale());
			products.setTitle(colorsEntity.getProductsEntity().getTitle());
			products.setHighlight(colorsEntity.getProductsEntity().getHighlight());
			products.setNew_product(colorsEntity.getProductsEntity().getNewproduct());
			products.setDetail(colorsEntity.getProductsEntity().getDetail());
			products.setId_color(colorsEntity.getId());
			products.setName_color(colorsEntity.getName());
			products.setCode_color(colorsEntity.getCode());
			products.setImg(colorsEntity.getImg());
			products.setCreateddate(colorsEntity.getProductsEntity().getCreatedDate());
			products.setModifieddate(colorsEntity.getProductsEntity().getModifiedDate());
			featuredProducts.add(products);
		}
		return featuredProducts;
	}

	@Override
	public List<ProductsModel> findProductsOfCategoryId(long id) {
		// TODO Auto-generated method stub
		List<ProductsModel> productsModels = new ArrayList<>();
		List<ProductsEntity> entities = productsRepository.findByCategoryEntity_Id(id);
		for (ProductsEntity productsEntity : entities) {
			ProductsModel productsModel = productsService.toModel(productsEntity);
			productsModels.add(productsModel);
		}
		return productsModels;
	}
	
}

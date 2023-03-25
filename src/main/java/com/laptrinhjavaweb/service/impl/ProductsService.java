package com.laptrinhjavaweb.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

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
	private ProductsConverter productsConverter;
	
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
	public List<ProductsModel> findProductOfCategory(long categoryid) {
		// TODO Auto-generated method stub
		List<ProductsModel> productsModels = new ArrayList<>();
		List<ProductsEntity> entities = productsRepository.findByCategoryId(categoryid);
		for (ProductsEntity productsEntity : entities) {
			ProductsModel productsModel = productsConverter.toModel(productsEntity);
			ColorsEntity colorsEntity = productsEntity.getColorsEntities().get(0);
			productsModel.setImg(colorsEntity.getImg());
			productsModels.add(productsModel);
		}
		return productsModels;
	}

	@Override
	public List<ProductsModel> findProductOfCategory(long id, Pageable pageable) {
		// TODO Auto-generated method stub
		List<ProductsModel> productsModels = new ArrayList<>();
		Page<ProductsEntity> page = productsRepository.findByCategoryIdPaginate( id,pageable);
		List<ProductsEntity> productsEntities = page.getContent();
		for (ProductsEntity productsEntity : productsEntities) {
			ProductsModel model = productsConverter.toModel(productsEntity);
			ColorsEntity colorsEntity = productsEntity.getColorsEntities().get(0);
			model.setImg(colorsEntity.getImg());
			productsModels.add(model);
		}
		return productsModels;
	}

	@Override
	public int getTotalItem(long id) {
		// TODO Auto-generated method stub
		int totalItem = productsRepository.getTotalItem(id);
		return totalItem;
	}

	@Override
	public ProductsModel getProductByID(long id) {
		// TODO Auto-generated method stub
		ProductsEntity productsEntity = productsRepository.findOneById(id);
		ProductsModel productsModel = productsConverter.toModel(productsEntity);
		ColorsEntity colorsEntity = productsEntity.getColorsEntities().get(0);
		productsModel.setImg(colorsEntity.getImg());
		productsModel.setColor(colorsEntity.getCode());
		return productsModel;
	}

	@Override
	public List<ProductsModel> getProductsByIdCategory(Long id) {
		// TODO Auto-generated method stub
		List<ProductsModel> productsModels = new ArrayList<>();
		List<ProductsEntity> productsEntities = productsRepository.findByCategoryEntity_Id(id);
		return productsModels;
	}
}

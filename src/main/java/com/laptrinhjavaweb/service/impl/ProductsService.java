package com.laptrinhjavaweb.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.laptrinhjavaweb.converter.ProductsConverter;
import com.laptrinhjavaweb.entity.ColorsEntity;
import com.laptrinhjavaweb.entity.ProductsEntity;
import com.laptrinhjavaweb.model.dto.ProductsDto;
import com.laptrinhjavaweb.model.response.FeaturedProducts;
import com.laptrinhjavaweb.model.response.ProductsOfCategoryResponse;
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
	public List<ProductsDto> findProductOfCategory(long categoryid) {
		// TODO Auto-generated method stub
		List<ProductsDto> productsModels = new ArrayList<>();
		List<ProductsEntity> entities = productsRepository.findByCategoryId(categoryid);
		for (ProductsEntity productsEntity : entities) {
			ProductsDto productsModel = productsConverter.toModel(productsEntity);
			ColorsEntity colorsEntity = productsEntity.getColorsEntities().get(0);
			productsModel.setImg(colorsEntity.getImg());
			productsModels.add(productsModel);
		}
		return productsModels;
	}

	@Override
	public List<ProductsOfCategoryResponse> findProductOfCategory(long id, Pageable pageable) {
		// TODO Auto-generated method stub
		List<ProductsOfCategoryResponse> productsModels = new ArrayList<>();
		Page<ProductsEntity> page = productsRepository.findByCategoryIdPaginate( id,pageable);
		List<ProductsEntity> productsEntities = page.getContent();
		for (ProductsEntity productsEntity : productsEntities) {
			/*ProductsDto model = productsConverter.toModel(productsEntity);*/
			ProductsOfCategoryResponse response = new ProductsOfCategoryResponse();
			response.setId(productsEntity.getId());
			response.setName(productsEntity.getName());
			response.setSizes(productsEntity.getSizes());
			response.setPrice(productsEntity.getPrice());
			response.setSale(productsEntity.getSale());
			response.setTitle(productsEntity.getTitle());
			response.setHighlight(productsEntity.getHighlight());
			response.setNewproduct(productsEntity.getNewproduct());
			response.setDetail(productsEntity.getDetail());
			ColorsEntity colorsEntity = productsEntity.getColorsEntities().get(0);
			response.setImg(colorsEntity.getImg());
			response.setNameColor(colorsEntity.getName());
			response.setCodeColor(colorsEntity.getCode());
			productsModels.add(response);
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
	public ProductsDto getProductByID(long id) {
		// TODO Auto-generated method stub
		ProductsEntity productsEntity = productsRepository.findOneById(id);
		ProductsDto productsModel = productsConverter.toModel(productsEntity);
		ColorsEntity colorsEntity = productsEntity.getColorsEntities().get(0);
		productsModel.setImg(colorsEntity.getImg());
		productsModel.setColor(colorsEntity.getCode());
		return productsModel;
	}

	@Override
	public List<ProductsDto> getProductsByIdCategory(Long id) {
		// TODO Auto-generated method stub
		List<ProductsDto> productsModels = new ArrayList<>();
		List<ProductsEntity> productsEntities = productsRepository.findByCategoryEntity_Id(id);
		return productsModels;
	}

	@Override
	public List<ProductsDto> searchProduct(String name,Pageable pageable) {
		// TODO Auto-generated method stub
		List<ProductsDto> productsDtos = new ArrayList<>();
		Page<ProductsEntity> page = productsRepository.searchProduct(name, pageable);
		List<ProductsEntity> productsEntities = page.getContent();
		for (ProductsEntity productsEntity : productsEntities) {
			ProductsDto productsDto = productsConverter.toModel(productsEntity);
			ColorsEntity colorsEntity = productsEntity.getColorsEntities().get(0);
			productsDto.setImg(colorsEntity.getImg());
			productsDtos.add(productsDto);
		}
		return productsDtos;
	}

	@Override
	public int getTotalItems(String name) {
		// TODO Auto-generated method stub
		int toTalItem = productsRepository.getTotalItems(name);
		return toTalItem;
	}
}

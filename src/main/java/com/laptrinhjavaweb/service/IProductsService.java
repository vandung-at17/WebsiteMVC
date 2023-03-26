package com.laptrinhjavaweb.service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.laptrinhjavaweb.model.dto.ProductsDto;
import com.laptrinhjavaweb.model.response.FeaturedProducts;

public interface IProductsService {
	List<FeaturedProducts> findAllFeaturedProducts();
	List<ProductsDto> findProductOfCategory(long categoryid);
	List<ProductsDto> getProductsByIdCategory(Long id);
	List<ProductsDto> findProductOfCategory (long id , Pageable pageable);
	int getTotalItem(long id);
	//
	public ProductsDto getProductByID (long id);
	
}

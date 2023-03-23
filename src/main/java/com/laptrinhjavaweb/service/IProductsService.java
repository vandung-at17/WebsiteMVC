package com.laptrinhjavaweb.service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.laptrinhjavaweb.model.dto.ProductsModel;
import com.laptrinhjavaweb.model.response.FeaturedProducts;

public interface IProductsService {
	List<FeaturedProducts> findAllFeaturedProducts();
	List<ProductsModel> findProductOfCategory(long categoryid);
	List<ProductsModel> getProductsByIdCategory(Long id);
	List<ProductsModel> findProductOfCategory (long id , Pageable pageable);
	int getTotalItem(long id);
	public ProductsModel getProductByID (long id);
}

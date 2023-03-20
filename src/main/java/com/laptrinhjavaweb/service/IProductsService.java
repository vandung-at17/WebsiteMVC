package com.laptrinhjavaweb.service;

import java.util.List;

import com.laptrinhjavaweb.model.dto.ProductsModel;
import com.laptrinhjavaweb.model.response.FeaturedProducts;

public interface IProductsService {
	List<FeaturedProducts> findAllFeaturedProducts();
	List<ProductsModel> findProductsOfCategoryId (long id);
}

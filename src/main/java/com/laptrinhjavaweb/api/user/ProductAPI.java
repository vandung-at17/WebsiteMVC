package com.laptrinhjavaweb.api.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.laptrinhjavaweb.service.IProductsService;

@RestController(value = "products")
@RequestMapping("/api")
public class ProductAPI {
	
	@Autowired
	private IProductsService productsService;
	
	
}

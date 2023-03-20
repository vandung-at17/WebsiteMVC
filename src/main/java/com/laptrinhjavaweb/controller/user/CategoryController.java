package com.laptrinhjavaweb.controller.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.laptrinhjavaweb.service.IProductsService;

@Controller
public class CategoryController {
	
	@Autowired
	private IProductsService productsService;
	
	@RequestMapping(value = "/loai-san-pham/{id}")
	public ModelAndView ProductOfCategory(@PathVariable Long id) {
		ModelAndView mav = new ModelAndView("user/products/categoryproducts");
		mav.addObject("products", productsService.findProductsOfCategoryId(1));
		return mav;
	}
}

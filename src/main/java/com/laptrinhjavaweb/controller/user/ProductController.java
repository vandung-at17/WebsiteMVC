package com.laptrinhjavaweb.controller.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.laptrinhjavaweb.service.IProductsService;
import com.laptrinhjavaweb.service.impl.ProductsService;

@Controller(value= "ProductController")
public class ProductController extends BaseController {
	
	@Autowired
	private IProductsService productsService;

	@RequestMapping(value = "/chi-tiet-san-pham/{id}", method = RequestMethod.GET)
	public ModelAndView Product(@PathVariable long id) {
		mvShare.setViewName("user/products/product");
		mvShare.addObject("product", productsService.getProductByID(id));
		return mvShare;
	}
}

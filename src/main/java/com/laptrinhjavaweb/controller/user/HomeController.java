package com.laptrinhjavaweb.controller.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.laptrinhjavaweb.model.response.FeaturedProducts;
import com.laptrinhjavaweb.repository.ColorsRepository;
import com.laptrinhjavaweb.service.ICategorysService;
import com.laptrinhjavaweb.service.IProductsService;
import com.laptrinhjavaweb.service.ISlidesService;

@Controller(value = "homeControllerOfUser")
public class HomeController extends BaseController{

	@Autowired
	private ISlidesService slidesService;
	
	@Autowired
	private IProductsService productsService;
	
	
	@Autowired
	private ICategorysService categorysService;
		
	@Autowired
	private ColorsRepository colorsRepository;
	
	
	@RequestMapping(value = "/trang-chu", method = RequestMethod.GET)
	public ModelAndView homePage() {
		mvShare.setViewName("user/home");
		mvShare.addObject("slides", slidesService.findAll());
		mvShare.addObject("categorys", categorysService.findAll());
		mvShare.addObject("FeaturedProducts", productsService.findAllFeaturedProducts());
		return mvShare;
	}

}
package com.laptrinhjavaweb.controller.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

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
	
	@RequestMapping(value = "/trang-chu", method = RequestMethod.GET)
	public ModelAndView homePage() {
		mvShare.addObject("slides", slidesService.findAll());
		mvShare.addObject("FeaturedProducts", productsService.findAllFeaturedProducts());
		mvShare.setViewName("user/home");
//		mvShare.setViewName("user/account/forget_password");
		return mvShare;
	}

	@RequestMapping(value = "/accessDenied", method = RequestMethod.GET)
	public ModelAndView accessDenied() {
		return new ModelAndView("redirect:/dang-nhap?accessDenied");
	}
	
	@RequestMapping(value = "/lien-he", method = RequestMethod.GET)
	public ModelAndView Contact() {
		mvShare.setViewName("user/contact");
		return mvShare;
	}
}
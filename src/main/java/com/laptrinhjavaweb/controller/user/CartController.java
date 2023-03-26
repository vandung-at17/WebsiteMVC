package com.laptrinhjavaweb.controller.user;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.laptrinhjavaweb.model.dto.CartDto;
import com.laptrinhjavaweb.service.ICartService;
import com.laptrinhjavaweb.service.ICategorysService;
import com.laptrinhjavaweb.service.IProductsService;
import com.laptrinhjavaweb.service.ISlidesService;

@Controller
public class CartController extends BaseController{
	
	@Autowired
	private ICartService cartService;
	
	@Autowired
	private ISlidesService slidesService;
	
	@Autowired
	private IProductsService productsService;
	
	
	@Autowired
	private ICategorysService categorysService;
	
	@RequestMapping(value= "/gio-hang", method = RequestMethod.GET)
	public ModelAndView homePage() {
		mvShare.setViewName("user/cart/listcart");
		mvShare.addObject("slides", slidesService.findAll());
		mvShare.addObject("categorys", categorysService.findAll());
		mvShare.addObject("FeaturedProducts", productsService.findAllFeaturedProducts());
		return mvShare;
	}
	
	@RequestMapping(value = "/AddCart/{id}", method = RequestMethod.GET)
	public String AddCart(HttpServletRequest request,HttpSession session, @PathVariable long id) {
		HashMap<Long, CartDto> cart=(HashMap<Long, CartDto>)session.getAttribute("Cart");
		if (cart == null) {
			cart = new HashMap<Long,CartDto>();
		}
		cartService.AddCart(id, cart);
		session.setAttribute("Cart", cart);
		session.setAttribute("TotalQuantyCart", cartService.TotalQuanty(cart));
		session.setAttribute("TotalPriceCart", cartService.totalAllPrice(cart));
		return "redirect:"+ request.getHeader("Referer");
	}
	
	@RequestMapping(value = "/EditCart/{id}/{quanty}", method = RequestMethod.GET)
	public String EditCart(HttpServletRequest request,HttpSession session, @PathVariable long id, @PathVariable int quanty) {
		HashMap<Long, CartDto> cart=(HashMap<Long, CartDto>)session.getAttribute("Cart");
		if (cart == null) {
			cart = new HashMap<Long,CartDto>();
		}
		cart = cartService.EditCart(id, quanty, cart);
		session.setAttribute("Cart", cart);
		session.setAttribute("TotalQuantyCart", cartService.TotalQuanty(cart));
		session.setAttribute("TotalPriceCart", cartService.totalAllPrice(cart));
		return "redirect:"+ request.getHeader("Referer");
	}
	
	@RequestMapping(value = "/DeleteCart/{id}", method = RequestMethod.GET)
	public String DeleteCart(HttpServletRequest request,HttpSession session, @PathVariable long id) {
		HashMap<Long, CartDto> cart=(HashMap<Long, CartDto>)session.getAttribute("Cart");
		if (cart == null) {
			cart = new HashMap<Long,CartDto>();
		}
		cartService.DeleteCart(id, cart);
		session.setAttribute("Cart", cart);
		session.setAttribute("TotalQuantyCart", cartService.TotalQuanty(cart));
		session.setAttribute("TotalPriceCart", cartService.totalAllPrice(cart));
		return "redirect:"+ request.getHeader("Referer");
	}
}

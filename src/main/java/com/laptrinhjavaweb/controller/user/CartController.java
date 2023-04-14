package com.laptrinhjavaweb.controller.user;

import java.util.HashMap;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.laptrinhjavaweb.entity.UserEntity;
import com.laptrinhjavaweb.model.dto.BillsDto;
import com.laptrinhjavaweb.model.dto.CartDto;
import com.laptrinhjavaweb.model.dto.UserDto;
import com.laptrinhjavaweb.model.request.UserRegisterRequest;
import com.laptrinhjavaweb.service.IBillDetailService;
import com.laptrinhjavaweb.service.IBillsService;
import com.laptrinhjavaweb.service.ICartService;
import com.laptrinhjavaweb.service.ICategorysService;
import com.laptrinhjavaweb.service.IProductsService;
import com.laptrinhjavaweb.service.ISlidesService;
import com.laptrinhjavaweb.service.IUserService;

@Controller
public class CartController extends BaseController{
	
	@Autowired
	private ICartService cartService;
	
	@Autowired
	private ISlidesService slidesService;
	
	@Autowired
	private IProductsService productsService;
	
	@Autowired
	private IUserService userService;
	
	@Autowired
	private ICategorysService categorysService;
	
	@Autowired
	private IBillsService billsService;
	
	@Autowired
	private IBillDetailService billDetailService;
	
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
	
	@RequestMapping(value = "/CheckOut", method = RequestMethod.GET)
	public ModelAndView CheckOut(HttpServletRequest request ) {
		BillsDto billsDto = new BillsDto();
		String email="";
		Cookie arr[] = request.getCookies();
		if (arr != null) {
			for (Cookie cookie : arr) {
				if (cookie.getName().equals("email")) {
					email= cookie.getValue();
				}
			}
		}
		UserDto userDto = userService.findOneByEmail(email);
		billsDto.setDisplay_name(userDto.getDisplay_name());
		billsDto.setEmail(email);
		billsDto.setAddress(userDto.getAddress());
		mvShare.setViewName("user/bills/checkout");
		mvShare.addObject("bills", billsDto);
		return mvShare;
	}
	
	@RequestMapping(value = "/CheckOut", method = RequestMethod.POST)
	public String CheckOut(HttpServletRequest request, HttpSession session, @ModelAttribute("bills") BillsDto billsDto) {
		billsDto.setQuanty(Integer.parseInt((String)session.getAttribute("TotalPriceCart")));
		billsDto.setTotal(Double.parseDouble((String)session.getAttribute("TotalQuantyCart")));
		if(billsService.addBills(billsDto)>0) {
			HashMap<Long, CartDto> carts = (HashMap<Long, CartDto>)session.getAttribute("Cart");
			billDetailService.addBillsDetail(carts);
		}
		session.removeAttribute("Cart");
		return "redirect:gio-hang";
	}
}

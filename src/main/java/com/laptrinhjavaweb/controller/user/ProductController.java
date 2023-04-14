package com.laptrinhjavaweb.controller.user;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.laptrinhjavaweb.model.dto.ProductsDto;
import com.laptrinhjavaweb.model.response.PaginateResponse;
import com.laptrinhjavaweb.service.IProductsService;

@Controller(value= "ProductController")
public class ProductController extends BaseController {
	
	@Autowired
	private IProductsService productsService;
	
	private int limit =9;
	private String key ;

	@RequestMapping(value = "/chi-tiet-san-pham/{id}", method = RequestMethod.GET)
	public ModelAndView Product(@PathVariable long id) {
		mvShare.setViewName("user/products/product");
		mvShare.addObject("product", productsService.getProductByID(id));
		return mvShare;
	}
	
	/*@RequestMapping(value = "/tim-kiem", method = RequestMethod.GET)
	public ModelAndView SearchProduct (@RequestParam String key) {
		int currentPage = 1;
		mvShare.addObject("keyword", key);
		Pageable pageable = new PageRequest(currentPage-1, limit);
		List<ProductsDto> productsDtos = productsService.searchProduct(key, pageable);
		mvShare.addObject("products", productsDtos);
		PaginateResponse paginateResponse = new PaginateResponse();
		paginateResponse.setTotalPage((int) Math.ceil((double) productsService.getTotalItems(key) /limit));
		paginateResponse.setPage(currentPage);
		mvShare.addObject("paginate", paginateResponse);
		mvShare.setViewName("user/products/searchproducts");
		return mvShare;
	}*/
	
	@RequestMapping(value = "/tim-kiem", method = RequestMethod.POST)
	public ModelAndView SearchProduct (HttpServletRequest request, HttpServletResponse response) {
		key = request.getParameter("key");
		int currentPage = 1;
		mvShare.addObject("keyword", key);
		Pageable pageable = new PageRequest(currentPage-1, limit);
		List<ProductsDto> productsDtos = productsService.searchProduct(key, pageable);
		mvShare.addObject("products", productsDtos);
		PaginateResponse paginateResponse = new PaginateResponse();
		paginateResponse.setTotalPage((int) Math.ceil((double) productsService.getTotalItems(key) /limit));
		paginateResponse.setPage(currentPage);
		mvShare.addObject("paginate", paginateResponse);
		mvShare.setViewName("user/products/searchproducts");
		return mvShare;
	}
	
	@RequestMapping(value = "/tim-kiem/{currentPage}", method = RequestMethod.GET)
	public ModelAndView SearchProduct (HttpServletRequest request, @PathVariable int currentPage) {
		//String key = request.getParameter("key");
		mvShare.addObject("keyword", key);
		Pageable pageable = new PageRequest(currentPage-1, limit);
		List<ProductsDto> productsDtos = productsService.searchProduct(key, pageable);
		mvShare.addObject("products", productsDtos);
		PaginateResponse paginateResponse = new PaginateResponse();
		paginateResponse.setTotalPage((int) Math.ceil((double) productsService.getTotalItems(key) /limit));
		paginateResponse.setPage(currentPage);
		mvShare.addObject("paginate", paginateResponse);
		mvShare.setViewName("user/products/searchproducts");
		return mvShare;
	}
	
}
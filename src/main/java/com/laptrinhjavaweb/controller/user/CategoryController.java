package com.laptrinhjavaweb.controller.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.laptrinhjavaweb.model.response.PaginateResponse;
import com.laptrinhjavaweb.service.IProductsService;

@Controller(value = "ProductOfCategoryController")
public class CategoryController extends BaseController{
	
	@Autowired
	private IProductsService productsService;
	
	private int limit =9;
	
	@RequestMapping(value = "/loai-san-pham/{id}",method = RequestMethod.GET)
	public ModelAndView ProductOfCategory(@PathVariable Long id) {
		mvShare.setViewName("user/products/categoryproducts");
		int currentPage = 1;
		mvShare.addObject("idCategory", id);
		Pageable pageable = new PageRequest(currentPage-1,limit);
		mvShare.addObject("products", productsService.findProductOfCategory(id, pageable));
		PaginateResponse paginateResponse = new PaginateResponse();
		paginateResponse.setTotalPage((int) Math.ceil((double) productsService.getTotalItem(id) /limit));
		paginateResponse.setPage(currentPage);
		mvShare.addObject("paginate", paginateResponse);
		return mvShare;
	}
	@RequestMapping(value = "/loai-san-pham/{id}/{currentPage}",method = RequestMethod.GET)
	public ModelAndView ProductOfCategoryPaginate(@PathVariable Long id,@PathVariable int currentPage) {
		mvShare.setViewName("user/products/categoryproducts");
		mvShare.addObject("idCategory", id);
		Pageable pageable = new PageRequest(currentPage-1,limit);
		mvShare.addObject("products", productsService.findProductOfCategory(id, pageable));
		PaginateResponse paginateResponse = new PaginateResponse();
		paginateResponse.setTotalPage((int) Math.ceil((double) productsService.getTotalItem(id) /limit));
		paginateResponse.setPage(currentPage);
		mvShare.addObject("paginate", paginateResponse);
		return mvShare;
	}
}

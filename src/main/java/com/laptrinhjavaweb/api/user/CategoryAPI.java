package com.laptrinhjavaweb.api.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.laptrinhjavaweb.model.response.ProductsOfCategoryResponse;
import com.laptrinhjavaweb.service.IProductsService;

@RestController(value = "productsOfCategory")
@RequestMapping("/api")
public class CategoryAPI {
	
	@Autowired
	private IProductsService productsService;
	private int limit =9;
	
	@GetMapping(value = "/loai-san-pham/{id}")
	public String ProductOfCategoryPaginate (@PathVariable Long id, @RequestParam int currentPage) {
		Pageable pageable = new PageRequest(currentPage-1,limit);
		List<ProductsOfCategoryResponse> products = productsService.findProductOfCategory(id, pageable);
		if (products.size()>0);
		String html ="<ul class='thumbnails'>";
		int i = 0;
		for ( ProductsOfCategoryResponse item : products) {
			html += "<li class='span4'>";
			html += "<div class='thumbnail'>";
			html += "<a href='product_details.html' class='overlay'></a>";
			html += "<a class='zoomTool' href='/WebsiteMVC/chi-tiet-san-pham/"+ item.getId()+"' title='add to cart' style='display: none;'><span class='icon-search'></span>QUICK VIEW</a>";
			html += "<a href='product_details.html'>";
			html += "<img src='/WebsiteMVC/template//user//assets//img//"+item.getImg()+"' alt=''>";
			html += "</a>";
			html += "<div class='caption cntr'>";
			html += "<p>"+item.getName()+"</p>";
			html += "<p><strong type='number' groupingUsed='true'>"+item.getPrice()+"d"+"</strong></p>";
			html += "<h4>";
			html += "<a class='shopBtn' href='#' title='add to cart'>Add to cart</a>";
			html += "</h4>";
			html += "<div class='actionList'>";
			html += "<a class='pull-left' href='#'>Add to Wish List </a>";
			html += "<a class='pull-left' href='#'> Add to Compare </a>";
			html += "</div>";
			html += "<br class='clr' />";
			html += "</div>";
			html += "</div>";
			html += "</li>";
			i = i+1;
			int a= i;
			if ((a)%3==0||(a)==products.size()) {
				html += "</ul>";
				if (a<products.size()) {
					html+= "<ul class='thumbnails'>";
				}
			}
		}
		return html;
	}
	
}

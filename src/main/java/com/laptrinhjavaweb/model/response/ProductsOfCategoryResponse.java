package com.laptrinhjavaweb.model.response;
import java.util.Date;

import com.laptrinhjavaweb.entity.CategorysEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductsOfCategoryResponse {
	private Long id;
	private String name;
	private String sizes;
	private Double price;
	private Integer sale;
	private String title;
	private Boolean highlight;
	private Boolean newproduct;
	private String detail;
	private Date createdDate;
	private Date modifiedDate;
	private String img;
	private String nameColor;
	private String codeColor;
}

package com.laptrinhjavaweb.model.response;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class FeaturedProducts {
	private long id_product;
	private long id_category;
	private String sizes;
	private String name;
	private Double price;
	private Integer sale;
	private String title;
	private Boolean highlight;
	private Boolean new_product;
	private String detail;
	private long id_color;
	private String name_color;
	private String code_color;
	private String img;
	private Date createddate;
	private Date modifieddate;
}

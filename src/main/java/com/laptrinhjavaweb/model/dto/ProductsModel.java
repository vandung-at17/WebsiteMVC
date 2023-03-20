package com.laptrinhjavaweb.model.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.laptrinhjavaweb.entity.CategorysEntity;
import com.laptrinhjavaweb.entity.ColorsEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductsModel {
	private Long id;
	private CategorysEntity categoryEntity;
	private String name;
	private String sizes;
	private Double price;
	private Integer sale;
	private String title;
	private Boolean highlight;
	private Boolean newproduct;
	private String detail;
	private List<ColorsEntity> colorsEntities = new ArrayList<>();
	private Date createdDate;
	private Date modifiedDate;
}

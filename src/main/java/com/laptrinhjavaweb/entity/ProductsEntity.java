package com.laptrinhjavaweb.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name = "products")
@Data
@EqualsAndHashCode(callSuper=false)
public class ProductsEntity extends BaseEntity {
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name= "id_category")
	private CategorysEntity categoryEntity;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "sizes")
	private String sizes;
	
	@Column(name =  "price")
	private Double price;
	
	@Column(name = "sale")
	private Integer sale;
	
	//Mô tả ngắn về sản phẩm
	@Column(name = "title")
	private String title;
	
	//Đánh dấu sản phẩm nổi bật
	@Column(name = "highlight")
	private Boolean highlight;
	
	//Đánh dấu sản phẩm mới
	@Column(name ="new_product")
	private Boolean newproduct;
	
	//Thông tin về sản phẩm 
	@Column(name="detail",columnDefinition="TEXT")
	private String detail;
	
	@OneToMany(mappedBy = "productsEntity")
	private List<ColorsEntity> colorsEntities = new ArrayList<>();
	
	@OneToMany(mappedBy = "product")
	private List<BillDetailEntity> billDetailREntities = new ArrayList<>();
}

package com.laptrinhjavaweb.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="billdetail")
@Data
//
public class BillDetailEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id ;
	
	@Column(name = "quanty")
	private int quaty;
	
	@Column (name = "total")
	private double total;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name ="id_bills")
	private BillsEntity billsEntity;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name ="id_product")
	private ProductsEntity product;
}

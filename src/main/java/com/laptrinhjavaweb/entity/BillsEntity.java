package com.laptrinhjavaweb.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

//Thông tin của người nào đó mua hàng
@Entity
@Table(name ="bills")
public class BillsEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id ;
	
	@Column(name= "email")
	private String email;
	
	@Column(name ="phone")
	private String phone;
	
	@Column(name ="display_name")
	private String display_name;
	
	@Column(name ="address")
	private String address;
	
	@Column(name ="total")
	private double total;
	
	@Column(name ="quanty")
	private int quanty;
	
	@Column(name ="note",columnDefinition = "TEXT")
	private String note;
	
	@OneToMany(mappedBy = "billsEntity")
	private List<BillDetailREntity> billDetailREntities = new ArrayList<>();
}

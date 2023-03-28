package com.laptrinhjavaweb.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.Getter;

//Định nghĩa đây là entity cha
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
@Getter
public abstract class BaseEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "createddate")
	@CreatedDate
	//@Setter
	private Date createdDate;
	
	@Column(name = "modifieddate")
	@LastModifiedDate
	//@Setter
	private Date modifiedDate;
	
	@Column(name = "createdby")
	@CreatedBy
	//@Setter
	private String createdBy;
	
	@Column(name = "modifiedby")
	@LastModifiedBy
	//@Setter
	private String  modifiedBy;
}

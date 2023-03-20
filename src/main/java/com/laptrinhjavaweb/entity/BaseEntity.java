package com.laptrinhjavaweb.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import lombok.Getter;
import lombok.Setter;

@MappedSuperclass
/*@EntityListeners(AuditingEntityListener.class)*/
@Getter
public abstract class BaseEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "createddate")
	//@CreatedDate
	@Setter
	private Date createdDate;
	
	@Column(name = "modifieddate")
	//@LastModifiedDate
	@Setter
	private Date modifiedDate;
}

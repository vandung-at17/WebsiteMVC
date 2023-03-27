package com.laptrinhjavaweb.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name = "role")
@Data
@EqualsAndHashCode(callSuper = false)
public class RoleEntity extends BaseEntity{
	@Column(name="name")
	private String name;
	
	@Column(name ="code")
	private String code;
	
	@ManyToMany(mappedBy = "roleEntities")
	private List<UserEntity> userEntities = new ArrayList<>();
}

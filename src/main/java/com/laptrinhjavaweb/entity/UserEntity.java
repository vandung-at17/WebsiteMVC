package com.laptrinhjavaweb.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "users")
@Data
@EqualsAndHashCode(callSuper=false)
@NoArgsConstructor
@AllArgsConstructor
public class UserEntity extends BaseEntity {
	
	@Column (name= "user", nullable = false)
	private String user;
	
	@Column (name = "password" , nullable = false)
	private String password;
	
	@Column (name = "display_name")
	private String display_name;
	
	@Column (name = "address", columnDefinition="TEXT")
	private String address;
	
	@Column (name = "email")
	private String email;
}

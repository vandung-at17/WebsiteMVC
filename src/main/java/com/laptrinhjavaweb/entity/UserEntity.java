package com.laptrinhjavaweb.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
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
	
	@Column (name = "password" , nullable = false)
	private String password;
	
	@Column (name = "display_name")
	private String display_name;
	
	@Column (name = "address", columnDefinition="TEXT")
	private String address;
	
	@Column (name = "email")
	private String email;
	
	@Column (name ="")
	private Integer status;
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name ="user_role",joinColumns= @JoinColumn(name = "userid"),
	inverseJoinColumns = @JoinColumn(name = "roleid"))
	private List<RoleEntity> roleEntities = new ArrayList<>();
}

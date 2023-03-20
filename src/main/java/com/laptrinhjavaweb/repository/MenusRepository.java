package com.laptrinhjavaweb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.laptrinhjavaweb.entity.MenusEntity;

@Repository
public interface MenusRepository extends JpaRepository<MenusEntity, Long>{
	
}

package com.laptrinhjavaweb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.laptrinhjavaweb.entity.CategorysEntity;
import com.laptrinhjavaweb.repository.custom.CategorysRepositoryCustom;

@Repository
public interface CategorysRepository extends JpaRepository<CategorysEntity, Long>, CategorysRepositoryCustom{

}

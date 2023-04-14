package com.laptrinhjavaweb.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.laptrinhjavaweb.entity.ColorsEntity;
import com.laptrinhjavaweb.repository.custom.ColorsRepositoryCustom;


@Repository
public interface ColorsRepository extends JpaRepository<ColorsEntity, Long> , ColorsRepositoryCustom{
	@Query("SELECT c from ColorsEntity as c group by c.productsEntity.id order by rand()")
	public List<ColorsEntity> getFeaturedProductss();
}

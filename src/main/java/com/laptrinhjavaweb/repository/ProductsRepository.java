package com.laptrinhjavaweb.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.laptrinhjavaweb.entity.ProductsEntity;
import com.laptrinhjavaweb.repository.custom.ProductsRepositoryCustom;

@Repository
public interface ProductsRepository extends JpaRepository<ProductsEntity, Long>, ProductsRepositoryCustom{

//	@Query("select new com.laptrinhjavaweb.model.response.FeaturedProducts(p.name,p.title) from ProductsEntity p ")
//	public List<FeaturedProducts> getFeaturedProductss();
//	
//	
//	@Query("select new com.laptrinhjavaweb.model.response.FeaturedProducts(p.id,p.id_category,p.sizes,p.name,p.price,p.sale,p.title,p.highlight,p.new_product,p.detail,c.id,c.name,c.code,c.img,p.createddate,p.modifieddate)\r\n" + 
//			"from ProductsEntity p , ColorsEntity c \r\n" + 
//			"where p.id = c.id_product\r\n" + 
//			"group by p.id,c.id_product")
//	public List<FeaturedProducts> getFeaturedProducts();
	
	public List<ProductsEntity> findByCategoryEntity_Id(long id);
}

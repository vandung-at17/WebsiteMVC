package com.laptrinhjavaweb.repository;

import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.laptrinhjavaweb.entity.ProductsEntity;
import com.laptrinhjavaweb.repository.custom.ProductsRepositoryCustom;

@Repository
public interface ProductsRepository extends JpaRepository<ProductsEntity, Long>, ProductsRepositoryCustom {

	@Query(value = "SELECT p.* FROM products as p inner join colors as c on p.id = c.id_product where p.id_category = ?1 group by p.id", nativeQuery = true)
	public List<ProductsEntity> findByCategoryId(long id);

	@Query(value = "SELECT  p.* FROM products as p inner join colors as c on p.id = c.id_product where p.id_category = ?1 group by p.id \n-- #pageable\n", 
			countQuery = "select count(*) from (select p.* FROM products as p inner join colors as c on p.id = c.id_product where p.id_category = ?1 group by p.id) as ds", 
			nativeQuery = true)
	Page<ProductsEntity> findByCategoryIdPaginate( long id, Pageable pageable);
	
	@Query(value ="select count(*) from (select p.* FROM products as p inner join colors as c on p.id = c.id_product where p.id_category = ?1 group by p.id) as ds",
	       nativeQuery = true)
	int getTotalItem(long id);
	
	ProductsEntity findOneById(long id);
	
	List<ProductsEntity> findByCategoryEntity_Id(long idcategory);
	
//	@Query(value ="SELECT  p.* FROM products as p inner join colors as c on p.id = c.id_product where p.name like %:keyword% group by p.id", nativeQuery= true)
//	List<ProductsEntity> searchProduct (@Param("keyword") String keyword);
	
	@Query(value ="SELECT  p.* FROM products as p inner join colors as c on p.id = c.id_product where p.name like %:keyword% group by p.id \n-- #pageable\n",
			countQuery = "select count(*) from (SELECT  p.* FROM products as p inner join colors as c on p.id = c.id_product where p.name like %:keyword% group by p.id) as ds",
			nativeQuery= true)
	Page<ProductsEntity> searchProduct (@Param("keyword") String keyword, Pageable pageable);
	
	@Query(value="select count(*) from (SELECT  p.* FROM products as p inner join colors as c on p.id = c.id_product where p.name like %:keyword% group by p.id) as ds",
		   nativeQuery = true)
	int getTotalItems(@Param("keyword") String keyword);
}

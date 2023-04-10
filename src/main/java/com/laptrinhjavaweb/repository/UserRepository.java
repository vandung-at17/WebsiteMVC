package com.laptrinhjavaweb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.laptrinhjavaweb.entity.UserEntity;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long>{
	
	UserEntity findOneByEmailAndStatus(String name, int status);
	UserEntity findOneByEmailAndPassword(String email, String password);
	
	@Modifying
	@Query(value="update users set password = ?1 where id = ?2", nativeQuery= true)
	void updatePassWordOfEmail(String passwordNew, long id);
}

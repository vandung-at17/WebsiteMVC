package com.laptrinhjavaweb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.laptrinhjavaweb.entity.BillsEntity;

@Repository
public interface BillsRepository extends JpaRepository<BillsEntity, Long> {
	@Query(value = "SELECT max(b.id) FROM websitespringmvc.bills as b", nativeQuery = true)
	long getIDLastBills();
}

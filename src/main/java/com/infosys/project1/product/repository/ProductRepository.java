package com.infosys.project1.product.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.infosys.project1.product.entity.Product;
@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

	List<Product> findAll();

	
	

}

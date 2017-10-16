package com.project.stitchlite.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.project.stitchlite.model.Product;

public interface ProductRepository extends CrudRepository<Product, Long>{
	
	List<Product> findByTitle(String title);

}

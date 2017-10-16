package com.project.stitchlite.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.project.stitchlite.model.Product;
import com.project.stitchlite.model.ShopifyProduct;

public interface ProductRepository extends CrudRepository<Product, Long>{
	
	List<Product> findByTitle(String title);
	
	Product findById(int id);

}

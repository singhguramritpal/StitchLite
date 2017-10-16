package com.project.stitchlite.service;

import java.util.List;

import com.project.stitchlite.model.Product;

public interface ProductService {

	public List<Product> getProductsFromShopify(); 
	
	public List<Product> findAll();
	
	public List<Product> findByTitle(String title);
	
}

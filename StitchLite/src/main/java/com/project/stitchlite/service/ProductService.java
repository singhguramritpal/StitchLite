package com.project.stitchlite.service;

import java.util.List;

import com.project.stitchlite.model.Product;
import com.project.stitchlite.model.ShopifyProduct;

public interface ProductService {

	public List<Product> getProductsFromShopify();
	
	public List<Product> getProductsFromVend();
	
	public List<Product> findAll();
	
	public List<Product> findProductByTitle(String title);

	void saveMultipleProducts(List<Product> products);

	void saveProduct(Product product);

	Product findProductById(int id);
	
}

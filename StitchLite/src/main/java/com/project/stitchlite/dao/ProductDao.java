package com.project.stitchlite.dao;

import java.util.List;

import com.project.stitchlite.model.Product;
import com.project.stitchlite.model.ShopifyProduct;

public interface ProductDao {
	
	public void saveProduct(Product product);
	
	public void saveMultipleProducts(List<Product> products);
	
	public List<Product> findAll();
	
	public List<Product> findProductByTitle(String title);
	
	public Product findProductById(int id);
	
	public void deleteProduct(Product product);

}

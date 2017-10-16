package com.project.stitchlite.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.project.stitchlite.model.Product;
import com.project.stitchlite.model.ShopifyProduct;
import com.project.stitchlite.repositories.ProductRepository;

@Component
public class ProductDaoImpl implements ProductDao {
	
	@Autowired
	private ProductRepository productRepo;

	@Override
	public void saveProduct(Product product) {
		productRepo.save(product);
	}

	@Override
	public void saveMultipleProducts(List<Product> products) {
		productRepo.save(products);
	}

	@Override
	public List<Product> findAll() {
		List<Product> products = (List<Product>) productRepo.findAll(); 
		return products;
	}

	@Override
	public List<Product> findProductByTitle(String title) {
		return productRepo.findByTitle(title);
	}
	
	@Override
	public Product findProductById(int id) {
		return productRepo.findById(id);
	}

	@Override
	public void deleteProduct(Product product) {
		productRepo.delete(product);
	}

}

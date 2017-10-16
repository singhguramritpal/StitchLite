package com.project.stitchlite.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.project.stitchlite.model.Product;
import com.project.stitchlite.repositories.ProductRepository;

@Component
public class ProductDaoImpl implements ProductDao {
	
	@Autowired
	private ProductRepository productRepo;

	public void saveProduct(Product product) {
		productRepo.save(product);
	}

	public void saveMultipleProducts(List<Product> products) {
		productRepo.save(products);
	}

	public List<Product> findAll() {
		List<Product> products = (List<Product>) productRepo.findAll(); 
		return products;
	}

	public List<Product> findProductByTitle(String title) {
		return productRepo.findByTitle(title);
	}

}

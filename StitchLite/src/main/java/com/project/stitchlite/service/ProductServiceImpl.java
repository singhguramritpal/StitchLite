package com.project.stitchlite.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.project.stitchlite.dao.ProductDao;
import com.project.stitchlite.integrate.ShopifyClient;
import com.project.stitchlite.model.Product;

@Component
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ShopifyClient shopifyClient;
	@Autowired
	private ProductDao productDao;
	
	public List<Product> getProductsFromShopify() {
		List<Product> products = shopifyClient.getProducts();
		productDao.saveMultipleProducts(products);
		return products;
	}
	
	public List<Product> findAll() {
		List<Product> products = productDao.findAll();
		return products;
	}

	public List<Product> findByTitle(String title) {
		return productDao.findProductByTitle(title);
	}

}

package com.project.stitchlite.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.project.stitchlite.builder.ProductBuilderShopify;
import com.project.stitchlite.builder.ProductBuilderVend;
import com.project.stitchlite.dao.ProductDao;
import com.project.stitchlite.dao.VariantDao;
import com.project.stitchlite.integrate.ShopifyClient;
import com.project.stitchlite.integrate.VendClient;
import com.project.stitchlite.model.Product;
import com.project.stitchlite.model.ShopifyProduct;
import com.project.stitchlite.model.Variant;
import com.project.stitchlite.model.VendProduct;

@Component
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ShopifyClient shopifyClient;
	@Autowired
	private VendClient vendClient;
	@Autowired
//	@Qualifier("ProductBuilderFromVendImpl")
	private ProductBuilderVend productVendBuilder;
	@Autowired
//	@Qualifier("ProductBuilderFromShopifyImpl")
	private ProductBuilderShopify productShopifyBuilder;
	@Autowired
	private ProductDao productDao;
	@Autowired
	private VariantDao variantDao;
	
	public List<Product> getProductsFromShopify() {
		List<ShopifyProduct> shopifyProducts = shopifyClient.getProducts();
		
		List<Product> products = productShopifyBuilder.buildListOfProducts(shopifyProducts);
		
		return products;
	}
	
	@Override
	public List<Product> getProductsFromVend() {
		List<VendProduct> vendProducts = vendClient.getProducts();
		List<Product> products = productVendBuilder.buildListOfProducts(vendProducts);
		return products;
	}
	
	@Override
	public void saveMultipleProducts(List<Product> products){
//		productDao.saveMultipleProducts(products);
		for(Product product:products){
			saveProduct(product);
		}
	}
	
	@Override
	public void saveProduct(Product product){
		productDao.saveProduct(product);
	}
	
	@Override
	public List<Product> findAll() {
		List<Product> products = productDao.findAll();
		return products;
	}

	@Override
	public List<Product> findProductByTitle(String title) {
		return productDao.findProductByTitle(title);
	}
	
	@Override
	public Product findProductById(int id) {
		return productDao.findProductById(id);
	}

}

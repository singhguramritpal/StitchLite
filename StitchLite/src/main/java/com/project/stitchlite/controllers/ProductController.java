package com.project.stitchlite.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.stitchlite.model.Product;
import com.project.stitchlite.service.ProductService;

@RestController
@RequestMapping("/api")
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@RequestMapping(value = "/sync", method = RequestMethod.POST)
	public @ResponseBody List<Product> syncProductsFromExternalApi(){
		
		List<Product> products = productService.getProductsFromShopify();
		if(products == null){
			products = productService.getProductsFromVend();
		} else{
			products.addAll(productService.getProductsFromVend());
		}
		
		productService.SaveMultipleProducts(products);
		
		return products;
		
	}
	
	@RequestMapping("/products")
	public @ResponseBody List<Product> getAllProducts(){
		List<Product> products  = productService.findAll();
		return products;
		
	}
	
	@RequestMapping("/products/{productId}")
	public @ResponseBody Product getProductById(@PathVariable int productId){

		Product product = productService.findProductById(productId);
		return product;
		
	}
	
}

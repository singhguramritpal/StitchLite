package com.project.stitchlite.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.stitchlite.model.Product;
import com.project.stitchlite.service.ProductService;

@RestController
@RequestMapping("/products")
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@RequestMapping("/getAll")
	public @ResponseBody List<Product> getAllProducts(){
		
		productService.getProductsFromShopify();
		List<Product> products  = productService.findAll();
		return products;
		
	}
	
	@RequestMapping("/getByTitle")
	public @ResponseBody List<Product> getProductByTitle(
			@RequestParam(value="title", required=true)String title){
		List<Product> products  = productService.findByTitle(title);
		return products;
		
	}

}

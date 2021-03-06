package com.project.stitchlite.builder;

import java.util.List;

import com.project.stitchlite.model.Product;

public interface ProductBuilderVend {
	
	public List<Product> buildListOfProducts(Object entities);

	Product buildProduct(Object entity, Product product);

}

package com.project.stitchlite.integrate;

import java.util.List;

import com.project.stitchlite.model.ShopifyProduct;

public interface ShopifyClient {
	
	public List<ShopifyProduct> getProducts();

}

package com.project.stitchlite.integrate;

import java.util.List;

import com.project.stitchlite.model.ShopifyProduct;
import com.project.stitchlite.model.VendProduct;

public interface VendClient {
	
	public List<VendProduct> getProducts();

}

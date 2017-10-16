package com.project.stitchlite.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties
public class VendProductsListObject {
	
	private List<VendProduct> products;

	public List<VendProduct> getProducts() {
		return products;
	}

	public void setProducts(List<VendProduct> products) {
		this.products = products;
	}

}

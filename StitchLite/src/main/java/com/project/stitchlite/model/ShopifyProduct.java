package com.project.stitchlite.model;

import java.util.List;

import javax.persistence.Entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties
public class ShopifyProduct {
	
	private Long id;
	private String title;

	private List<ShopifyVariant> variants;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	

	public List<ShopifyVariant> getVariants() {
		return variants;
	}

	public void setVariants(List<ShopifyVariant> variants) {
		this.variants = variants;
	}

}

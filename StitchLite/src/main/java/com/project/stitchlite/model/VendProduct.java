package com.project.stitchlite.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties
public class VendProduct {
	
	@JsonProperty("base_name")
	private String name;
	private Boolean active;
	private String sku;
	private Double price;
	@JsonProperty("variant_option_two_value")
	private String size;
	@JsonProperty("variant_option_one_value")
	private String color;
	@JsonProperty("updated_at")
	private String dateUpdated;
	private List<VendInventory> inventory;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSku() {
		return sku;
	}
	public void setSku(String sku) {
		this.sku = sku;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getDateUpdated() {
		return dateUpdated;
	}
	public void setDateUpdated(String dateUpdated) {
		this.dateUpdated = dateUpdated;
	}
	public List<VendInventory> getInventory() {
		return inventory;
	}
	public void setInventory(List<VendInventory> inventory) {
		this.inventory = inventory;
	}
	public Boolean getActive() {
		return active;
	}
	public void setActive(Boolean active) {
		this.active = active;
	}

}

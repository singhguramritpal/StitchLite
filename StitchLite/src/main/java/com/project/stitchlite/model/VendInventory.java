package com.project.stitchlite.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class VendInventory {
	
	private int count;
	@JsonProperty("outlet_name")
	private String outletName;

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public String getOutletName() {
		return outletName;
	}

	public void setOutletName(String outletName) {
		this.outletName = outletName;
	}

}

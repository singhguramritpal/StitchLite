package com.project.stitchlite.dao;

import com.project.stitchlite.model.Variant;

public interface VariantDao {
	
	public Variant findBySku(String sku);

	void deleteVariant(Variant variant);

}

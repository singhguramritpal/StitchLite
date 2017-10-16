package com.project.stitchlite.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.project.stitchlite.model.Variant;
import com.project.stitchlite.repositories.VariantRepository;

@Component
public class VariantDaoImpl implements VariantDao {

	@Autowired
	private VariantRepository variantRepo;
	
	@Override
	public Variant findBySku(String sku) {
		return variantRepo.findBySku(sku);
	}
	
	@Override
	public void deleteVariant(Variant variant) {
		variantRepo.delete(variant);
	}

}

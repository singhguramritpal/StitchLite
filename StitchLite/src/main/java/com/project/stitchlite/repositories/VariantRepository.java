package com.project.stitchlite.repositories;

import org.springframework.data.repository.CrudRepository;

import com.project.stitchlite.model.Variant;

public interface VariantRepository extends CrudRepository<Variant, Long> {
	
	Variant findBySku(String sku);

}

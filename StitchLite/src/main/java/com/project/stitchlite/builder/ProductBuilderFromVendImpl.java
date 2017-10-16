package com.project.stitchlite.builder;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.springframework.stereotype.Component;

import com.project.stitchlite.model.Product;
import com.project.stitchlite.model.Variant;
import com.project.stitchlite.model.VendProduct;

@Component
public class ProductBuilderFromVendImpl implements ProductBuilderVend {

	@Override
	public Product buildProduct(Object entity, Product product) {
		if(product ==null)
			product = new Product();
		VendProduct vendProduct = (VendProduct) entity;
		Variant variant = new Variant();
		
		//Buuilding the Variant
		variant.setColor(vendProduct.getColor());
		variant.setDateUpdated(convertStringToDate(vendProduct.getDateUpdated()));
		variant.setDateCreated(convertStringToDate(vendProduct.getDateUpdated()));
		variant.setPrice(vendProduct.getPrice());
		if(vendProduct.getInventory() == null){
			return null;
		}
		variant.setQuantity(vendProduct.getInventory().get(0).getCount());
		variant.setSize(vendProduct.getSize());
		variant.setSku(vendProduct.getSku());
		
		//building the product, adding the variant to the product
		product.setTitle(vendProduct.getName());
		if(product.getVariants() == null){
			product.setVariants(new ArrayList<Variant>());
		}
		product.getVariants().add(variant);
		
		return product;
	}

	@Override
	public List<Product> buildListOfProducts(Object entities) {
		@SuppressWarnings("unchecked")
		List<VendProduct> vendProducts = (List<VendProduct>) entities;
		Map<String, Product> mapOfProducts = new HashMap<String, Product>();
		List<Product> products = new ArrayList<Product>();
		
		for(VendProduct p: vendProducts){
			if(mapOfProducts.get(p.getName()) == null){
				Product product = buildProduct(p, null);
				if(product==null){
					continue;
				}
				mapOfProducts.put(product.getTitle(), product);
			} else{
				buildProduct(p, mapOfProducts.get(p.getName()));
			}
		}
		
		for(Entry<String, Product> entry:mapOfProducts.entrySet()){
			products.add(entry.getValue());
		}
		return products;
	}
	
	private Date convertStringToDate(String time){
		Date date;
		try {
			date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(time);
			return date;
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}

}

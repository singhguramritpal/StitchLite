package com.project.stitchlite.builder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.springframework.stereotype.Component;

import com.project.stitchlite.model.Product;
import com.project.stitchlite.model.ShopifyProduct;
import com.project.stitchlite.model.ShopifyVariant;
import com.project.stitchlite.model.Variant;

@Component
public class ProductBuilderFromShopifyImpl implements ProductBuilderShopify{

	@Override
	public List<Product> buildListOfProducts(Object entities) {
		@SuppressWarnings("unchecked")
		List<ShopifyProduct> shopifyProducts = (List<ShopifyProduct>) entities;
		List<Product> products = new ArrayList<Product>();
		
		for(ShopifyProduct p: shopifyProducts){
			Product product = buildProduct(p, null);
			if(product!=null){
				products.add(product);
			}
		}
		return products;
	}

	@Override
	public Product buildProduct(Object entity, Product product) {
		
		List<Variant> variants = new ArrayList<Variant>();
		ShopifyProduct shopifyProduct = (ShopifyProduct) entity;
		List<ShopifyVariant> shopifyVariants = shopifyProduct.getVariants();
		if(product==null){
			product = new Product();
		}
		
		for(ShopifyVariant v : shopifyVariants){
			Variant variant = new Variant();
			variant.setColor(v.getColor());
			variant.setDateCreated(v.getDateCreated());
			variant.setDateUpdated(v.getDateUpdated());
			variant.setPrice(v.getPrice());
			variant.setQuantity(v.getQuantity());
			variant.setSize(v.getSize());
			variant.setSku(v.getSku());
			variants.add(variant);
		}
		
		product.setTitle(shopifyProduct.getTitle());
		product.setVariants(variants);
		
		return product;
	}

}

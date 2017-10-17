package com.project.stitchlite.integrate;

import java.util.List;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.project.stitchlite.model.ShopifyProduct;
import com.project.stitchlite.model.VendProduct;
import com.project.stitchlite.model.VendProductsListObject;

@Component
public class VendClientImpl implements VendClient{
	
	String token = "ACCESS-TOKEN";

	public List<VendProduct> getProducts() {
		
		RestTemplate restTemplate = new RestTemplate();
		String url = "https://stitchobia.vendhq.com/api/products?active=true";
		
		// Adding the Auth headers to the Request
		HttpHeaders headers = new HttpHeaders();
		headers.set("Authorization", "Bearer "+token);
		@SuppressWarnings({ "unchecked", "rawtypes" })
		HttpEntity entity = new HttpEntity(null, headers);

		restTemplate = new RestTemplate();
		restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
		restTemplate.getMessageConverters().add(new StringHttpMessageConverter());

		// Making a call to the Shopify API
		ResponseEntity<VendProductsListObject> response = restTemplate.exchange(url, HttpMethod.GET, entity, VendProductsListObject.class);
		List<VendProduct> vendProducts = response.getBody().getProducts();
		
		return vendProducts;
	}
}

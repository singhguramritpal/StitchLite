package com.project.stitchlite.integrate;


import java.util.List;

import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.project.stitchlite.model.ShopifyProductsListObject;
import com.project.stitchlite.model.ShopifyProduct;
import com.project.stitchlite.model.ShopifyVariant;

@Component
public class ShopifyClientImpl implements ShopifyClient{

	
//	@Autowired
//	private RestTemplate restTemplate;
	
	private String apiKey = "ca7371a56a00e99fa1f689d67a788efc";
	private String apiPassword = "5d0c9f8cacab1f2b33a84305986b4957";
	
	public List<ShopifyProduct> getProducts() {
		RestTemplate restTemplate = new RestTemplate();
		String url = "https://stitchobia.myshopify.com/admin/products.json";
		
		// Adding the Auth headers to the Request
		HttpHeaders headers = new HttpHeaders();
		String userpass = apiKey+":"+apiPassword;
        String basicAuth = "Basic " + new String(new Base64().encode(userpass.getBytes()));
		headers.set(HttpHeaders.AUTHORIZATION, basicAuth);
		@SuppressWarnings({ "unchecked", "rawtypes" })
		HttpEntity entity = new HttpEntity(null, headers);

		restTemplate = new RestTemplate();
		restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
		restTemplate.getMessageConverters().add(new StringHttpMessageConverter());

		// Making a call to the Shopify API
		ResponseEntity<ShopifyProductsListObject> response1 = restTemplate.exchange(url, HttpMethod.GET, entity, ShopifyProductsListObject.class);
		List<ShopifyProduct> products = response1.getBody().getProducts();
		
		
		return products;
	}
	
}

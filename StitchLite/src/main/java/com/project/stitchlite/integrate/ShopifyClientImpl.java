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
	
	private String apiKey = "API-KEY";
	private String apiPassword = "API-PASSWORD";
	
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
		
//		for(Product product:products){
//			System.out.println(product.getTitle());
//			System.out.println(product.getId());
//			for(Variant v:product.getVariants()){
//				System.out.println(v.getColor() + " :Color");
//				System.out.println(v.getId() + " :id");
//				System.out.println(v.getPrice() + " :Price");
//				System.out.println(v.getQuantity()+ " :Quantity");
//				System.out.println(v.getSize()+ " :Size");
//				System.out.println(v.getSku() + " :SKU");
//				System.out.println(v.getDateCreated() + " :Date Created");
//				System.out.println(v.getDateUpdated() + " :Date Updated");
//				System.out.println();
//				System.out.println();
//			}
//			System.out.println();
//			System.out.println("-----------");
//			System.out.println();
//		}
		
		return products;
	}
	
}

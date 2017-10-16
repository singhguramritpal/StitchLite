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

import com.project.stitchlite.model.Product;
import com.project.stitchlite.model.VendProduct;
import com.project.stitchlite.model.VendProductsListObject;

@Component
public class VendClientImpl implements VendClient{
	
	String token = "KiQSsELLtoGzmctdi0DRu_OnxVLf8H37QlRba8WN";

	public List<Product> getProducts() {
		
		RestTemplate restTemplate = new RestTemplate();
		String url = "https://stitchobia.vendhq.com/api/products";
		
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
		List<VendProduct> products = response.getBody().getProducts();
		int i=0;
		for(VendProduct p:products){
			if(p.getActive()){
				System.out.println(p.getColor());
				System.out.println(p.getName());
				System.out.println(p.getSize());
				System.out.println(p.getSku());
				System.out.println(p.getActive());
				System.out.println(p.getDateUpdated());
				System.out.println(p.getPrice());
				if(p.getInventory()!=null)
					System.out.println(p.getInventory().get(0).getCount());
				else
					System.out.println("No Inventory" + p.getInventory());
				System.out.println();
				System.out.println("----------");
				System.out.println();
				i++;
			}
		}
		System.out.println(i + " - "+ products.size());
		return null;
	}
}

package com.project.stitchlite.integrate;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class VendClientImplTest {

	@Autowired
	private VendClient VendClient;
	
	@Test
	public void testGetProducts() {
		
		VendClient.getProducts();
	}

}

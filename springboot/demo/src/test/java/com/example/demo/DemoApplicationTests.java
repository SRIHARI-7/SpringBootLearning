package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.client.RestTemplate;

import com.example.demo.entities.Product;

@SpringBootTest
class DemoApplicationTests {
	@Autowired
	Product product;

	@Value("${productapi.services.url}")
	private String baseUrl;

	@Test
	void getProducts() {
		System.out.println(baseUrl);
		RestTemplate restTemplate=new RestTemplate();
		product= restTemplate.getForObject(baseUrl+"4", Product.class);
		assertNotNull(product);
		assertEquals("Vadai", product.getName());
	}
	@Test
	void postProduct(){
		

		RestTemplate restTemplate=new RestTemplate();
		product.setName("Aapam");
		product.setDescription("Curvy");
		product.setPrice(15);
		Product newproduct= restTemplate.postForObject(baseUrl, product, Product.class);
		assertNotNull(newproduct.getId());
		assertEquals("Aapam",newproduct.getName());
	}

	@Test
	void updateProducts() {
		RestTemplate restTemplate=new RestTemplate();
		product= restTemplate.getForObject(baseUrl+"4", Product.class);
		product.setPrice(12);
		restTemplate.put(baseUrl, product);

	}


	

}

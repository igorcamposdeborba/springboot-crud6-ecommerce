package com.igorborba.ecommerce;

import java.util.Arrays;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.igorborba.ecommerce.entities.Category;
import com.igorborba.ecommerce.entities.Product;
import com.igorborba.ecommerce.repositories.CategoryRepository;
import com.igorborba.ecommerce.repositories.ProductRepository;

@SpringBootApplication
public class EcommerceApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(EcommerceApplication.class, args);
	}

	@Autowired
	CategoryRepository categoryRepository;
	
	@Autowired
	ProductRepository productRepository;
	
	@Override
	public void run(String... args) throws Exception {
		Category category1 = new Category(null, "Informática");
		Category category2 = new Category(null, "Escritório");
		
		Product product1 = new Product(null, "Notebook Dell", 6300.0);
		Product product2 = new Product(null, "Mouse", 120.0);
		Product product3 = new Product(null, "Impressora", 800.0);
		
		category1.getProduct().addAll(Arrays.asList(product1, product2, product3));
		category2.getProduct().addAll(Arrays.asList(product2));
		
		product1.getCategory().add(category1);
		product2.getCategory().addAll(Arrays.asList(category1, category2));
		product3.getCategory().add(category1);
		
		categoryRepository.saveAll(Arrays.asList(category1, category2));
		productRepository.saveAll(Arrays.asList(product1, product2, product3));
	}
}

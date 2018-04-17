package com.company;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;

import com.company.model.Product;
import com.company.repository.ProductRepository;

@SpringBootApplication
@EnableScheduling
public class CiApplication {

	public static void main(String[] args) {
		SpringApplication.run(CiApplication.class, args);
	}

	@Bean
	ApplicationRunner init(ProductRepository repository) {
		return args -> {
			Product product = new Product();
			product.setName("Apple");
			product.setDescription("Red fruit");
			repository.save(product);
		};
	}
}

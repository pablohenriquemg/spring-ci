package com.company.controller;

import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.company.model.Product;
import com.company.payload.GenericResponse;
import com.company.service.ProductService;

@RestController
@RequestMapping("/products")
public class ProductController {

	@Autowired
	private ProductService productService;

	@GetMapping
	public GenericResponse<?> getProducts() {
		return productService.findAll();
	}

	@PostMapping
	public GenericResponse<?> saveProduct(@NotNull @RequestBody Product product) {
		return productService.save(product);
	}
}

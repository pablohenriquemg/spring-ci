package com.company.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.model.Product;
import com.company.payload.GenericResponse;
import com.company.payload.MessageResponse;
import com.company.repository.ProductRepository;
import com.company.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository productRepository;

	@Override
	public GenericResponse<?> findAll() {
		try {
			return new GenericResponse<>(productRepository.findAll(), null);
		} catch (Exception e) {
			MessageResponse error = new MessageResponse("not.located", "Products not find, try again later.");
			return new GenericResponse<>(null, error);
		}
	}

	@Override
	public GenericResponse<?> save(Product product) {
		try {
			return new GenericResponse<>(productRepository.save(product), null);
		} catch (Exception e) {
			MessageResponse error = new MessageResponse("not.saved", "Product not saved, try again later.");
			return new GenericResponse<>(null, error);
		}
	}

}

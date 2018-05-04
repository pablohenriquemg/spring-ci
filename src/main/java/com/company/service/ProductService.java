package com.company.service;

import com.company.model.Product;
import com.company.payload.GenericResponse;

public interface ProductService {

	GenericResponse<?> findAll();

	GenericResponse<?> save(Product product);
}

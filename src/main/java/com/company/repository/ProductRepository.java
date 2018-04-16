package com.company.repository;

import java.util.List;

import org.springframework.data.repository.Repository;

import com.company.model.Product;

public interface ProductRepository extends Repository<Product, Long> {

	Product save(Product entity);

	List<Product> findAll();

	Product findById(Long id);
}

package com.company.repository;

import java.util.List;

import org.springframework.data.repository.Repository;

import com.company.model.Department;

public interface DepartmentRepository extends Repository<Department, Long> {

	Department save(Department entity);

	List<Department> findAll();

	Department findById(Long id);

}

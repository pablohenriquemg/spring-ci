package com.company.service;

import com.company.model.Department;
import com.company.payload.GenericResponse;

public interface DepartmentService {

	GenericResponse<?> findAll();

	GenericResponse<?> findById(Long id);

	GenericResponse<?> save(Department department);
}

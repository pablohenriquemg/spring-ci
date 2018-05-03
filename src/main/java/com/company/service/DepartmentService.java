package com.company.service;

import java.util.List;

import com.company.model.Department;

public interface DepartmentService {

	List<Department> findAll();

	Department save(Department department);
}

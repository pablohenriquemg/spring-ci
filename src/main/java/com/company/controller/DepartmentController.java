package com.company.controller;

import java.util.List;

import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.company.model.Department;
import com.company.payload.GenericResponse;
import com.company.service.DepartmentService;

@RestController
@RequestMapping("/departments")
public class DepartmentController {

	@Autowired
	private DepartmentService departmentService;

	@GetMapping
	public GenericResponse<List<Department>> getDepartments() {
		List<Department> list = departmentService.findAll();
		return new GenericResponse<>(list, null);
	}

	@PostMapping
	public Department saveDepartment(@NotNull @RequestBody Department department) {
		return departmentService.save(department);
	}
}

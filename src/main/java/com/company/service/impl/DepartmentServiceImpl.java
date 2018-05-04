package com.company.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.model.Department;
import com.company.payload.GenericResponse;
import com.company.payload.MessageResponse;
import com.company.repository.DepartmentRepository;
import com.company.service.DepartmentService;

@Service
public class DepartmentServiceImpl implements DepartmentService {

	@Autowired
	private DepartmentRepository departmentRepository;

	@Override
	public GenericResponse<?> findAll() {
		try {
			return new GenericResponse<>(departmentRepository.findAll(), null);
		} catch (Exception e) {
			MessageResponse error = new MessageResponse("not.located", "Departments not find, try again later.");
			return new GenericResponse<>(null, error);
		}
	}

	@Override
	public GenericResponse<?> save(Department department) {
		try {
			return new GenericResponse<>(departmentRepository.save(department), null);
		} catch (Exception e) {
			MessageResponse error = new MessageResponse("not.saved", "Department not saved, try again later.");
			return new GenericResponse<>(null, error);
		}
	}

	@Override
	public GenericResponse<?> findById(Long id) {
		Department dpt = departmentRepository.findById(id);
		if (dpt == null) {
			MessageResponse error = new MessageResponse("not.found", "Department not found");
			return new GenericResponse<>(null, error);
		}
		return new GenericResponse<>(dpt, null);
	}

}

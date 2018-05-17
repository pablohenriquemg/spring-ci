package com.company.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.exception.BadRequestException;
import com.company.exception.NotFoundException;
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
			MessageResponse error = new MessageResponse("not.located", "Departments not find, please try again later.");
			GenericResponse<?> genericResponse = new GenericResponse<>().withError(error);
			throw new BadRequestException(genericResponse);
		}
	}

	@Override
	public GenericResponse<?> save(Department department) {
		try {
			return new GenericResponse<>(departmentRepository.save(department), null);
		} catch (Exception e) {
			MessageResponse error = new MessageResponse("not.saved",
					"Department not saved, please check the fields and then try again.");
			GenericResponse<?> genericResponse = new GenericResponse<>().withError(error);
			throw new BadRequestException(genericResponse);
		}
	}

	@Override
	public GenericResponse<?> findById(Long id) {
		Department dpt = departmentRepository.findById(id);
		if (dpt == null) {
			MessageResponse error = new MessageResponse("not.found", "Department not found");
			GenericResponse<?> genericResponse = new GenericResponse<>().withError(error);
			throw new NotFoundException(genericResponse);
		}
		return new GenericResponse<>(dpt, null);
	}

}

package com.company.service;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

import java.io.IOException;
import java.util.ArrayList;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.company.exception.BadRequestException;
import com.company.exception.NotFoundException;
import com.company.model.Department;
import com.company.repository.DepartmentRepository;
import com.company.service.impl.DepartmentServiceImpl;

@RunWith(MockitoJUnitRunner.class)
public class DepartmentServiceTest {

	@InjectMocks
	private DepartmentServiceImpl deptServImpl;

	@Mock
	private DepartmentRepository deptRepo;

	@Test
	public void saveDepartmentTest() throws IOException {
		Department department = getFakeDepartment();
		department.setId(1l);
		when(deptRepo.save(department)).thenReturn(department);
		deptServImpl.save(department);
		assertNotNull(department.getId());
	}

	@Test(expected = BadRequestException.class)
	public void saveDepartmentFailTest() throws IOException {
		Department department = getFakeDepartment();
		when(deptRepo.save(department)).thenThrow(new BadRequestException());
		deptServImpl.save(department);
	}

	@Test
	public void getAllDepartmentsTest() throws IOException {
		when(deptRepo.findAll()).thenReturn(new ArrayList<>());
		deptServImpl.findAll();
	}

	@Test(expected = BadRequestException.class)
	public void getAllDepartmentsFailTest() throws IOException {
		when(deptRepo.findAll()).thenThrow(new BadRequestException());
		deptServImpl.findAll();
	}

	@Test
	public void getDepartmentByIdTest() throws IOException {
		when(deptRepo.findById(1l)).thenReturn(new Department());
		deptServImpl.findById(1l);
	}

	@Test(expected = NotFoundException.class)
	public void getDepartmentByIdFailTest() throws IOException {
		when(deptRepo.findById(10l)).thenThrow(new NotFoundException());
		deptServImpl.findById(10l);
	}

	private Department getFakeDepartment() {
		Department d = new Department();
		d.setDescription("Fake description");
		d.setName("Fake name");
		return d;
	}
}

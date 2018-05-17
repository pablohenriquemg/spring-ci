package com.company.service;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

import java.io.IOException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.company.exception.BadRequestException;
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
	public void saveDepartment() throws IOException {
		Department department = getFakeDepartment();
		department.setId(1l);
		when(deptRepo.save(department)).thenReturn(department);
		deptServImpl.save(department);
		assertNotNull(department.getId());
	}

	@Test(expected = BadRequestException.class)
	public void saveDepartmentFail() throws IOException {
		Department department = getFakeDepartment();
		when(deptRepo.save(department)).thenThrow(new BadRequestException());
		deptServImpl.save(department);
	}

	private Department getFakeDepartment() {
		Department d = new Department();
		d.setDescription("Fake description");
		d.setName("Fake name");
		return d;
	}
}

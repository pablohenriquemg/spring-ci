package com.company.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.json.JSONObject;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.company.service.DepartmentService;

public class DepartmentControllerTest extends BaseControllerTest {

	private MockMvc mockMvc;

	@Mock
	private DepartmentService departmentService;

	@InjectMocks
	private DepartmentController departmentController;

	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		mockMvc = MockMvcBuilders.standaloneSetup(departmentController).build();
	}

	@Test
	public void getAllDepartmentsTest() throws Exception {
		mockMvc.perform(get("/departments")).andExpect(status().isOk());
	}

	@Test
	public void getDepartmentByIdTest() throws Exception {
		mockMvc.perform(get("/departments/1")).andExpect(status().isOk());
	}

	@Test
	public void saveDepartmentTest() throws Exception {
		mockMvc.perform(post("/departments").content(mockDepartment()).contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk());
	}

	private String mockDepartment() throws Exception {
		JSONObject json = new JSONObject();
		json.put("name", "Department A");
		json.put("description", "Department description");
		return json.toString();
	}
}

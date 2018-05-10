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

import com.company.service.UserService;

public class UserControllerTest extends BaseControllerTest {

	private MockMvc mockMvc;

	@Mock
	private UserService userService;

	@InjectMocks
	private UserController userController;

	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		mockMvc = MockMvcBuilders.standaloneSetup(userController).build();
	}

	@Test
	public void getAllUsersTest() throws Exception {
		mockMvc.perform(get("/users")).andExpect(status().isOk());
	}

	@Test
	public void getUserByIdTest() throws Exception {
		mockMvc.perform(get("/users/1")).andExpect(status().isOk());
	}

	@Test
	public void saveUserTest() throws Exception {
		mockMvc.perform(post("/users").content(mockUser()).contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk());
	}

	private String mockUser() throws Exception {
		JSONObject json = new JSONObject();
		json.put("username", "admin");
		json.put("email", "admin");
		json.put("password", "admin");
		return json.toString();
	}
}

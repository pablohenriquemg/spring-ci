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
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.company.exception.BadRequestException;
import com.company.exception.NotFoundException;
import com.company.model.User;
import com.company.repository.UserRepository;
import com.company.service.impl.UserServiceImpl;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceTest {

	@InjectMocks
	private UserServiceImpl userServImpl;

	@Mock
	private UserRepository userRepo;

	@Mock
	private BCryptPasswordEncoder passwordEncoder;

	@Test
	public void saveUserTest() throws IOException {
		User user = getFakeUser();
		user.setId(1l);
		when(userRepo.save(user)).thenReturn(user);
		userServImpl.save(user);
		assertNotNull(user.getId());
	}

	@Test(expected = BadRequestException.class)
	public void saveUserFailTest() throws IOException {
		User user = getFakeUser();
		when(userRepo.save(user)).thenThrow(new BadRequestException());
		userServImpl.save(user);
		assertNotNull(user.getId());
	}

	@Test
	public void getAllUserTest() throws IOException {
		when(userRepo.findAll()).thenReturn(new ArrayList<>());
		userServImpl.findAll();
	}

	@Test(expected = BadRequestException.class)
	public void getAllUserFailTest() throws IOException {
		when(userRepo.findAll()).thenThrow(new BadRequestException());
		userServImpl.findAll();
	}

	@Test
	public void getUserByIdTest() throws IOException {
		when(userRepo.findById(1l)).thenReturn(new User());
		userServImpl.findById(1l);
	}

	@Test(expected = NotFoundException.class)
	public void getUserIdFailTest() throws IOException {
		when(userRepo.findById(10l)).thenThrow(new NotFoundException());
		userServImpl.findById(10l);
	}

	private User getFakeUser() {
		User u = new User();
		u.setEmail("user@user.com");
		u.setUsername("user");
		u.setPassword("123");
		return u;
	}
}

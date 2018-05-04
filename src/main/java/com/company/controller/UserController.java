package com.company.controller;

import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.company.model.User;
import com.company.payload.GenericResponse;
import com.company.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserService userService;

	@GetMapping
	public GenericResponse<?> getUsers() {
		return userService.findAll();
	}

	@PostMapping
	public GenericResponse<?> saveUser(@NotNull @RequestBody User user) {
		return userService.save(user);
	}
}

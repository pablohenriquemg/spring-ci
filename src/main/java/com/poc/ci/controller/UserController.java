package com.poc.ci.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

	@RequestMapping("/users")
	public List<String> getUsers() {
		List<String> list = new ArrayList<>();
		list.add("jose");
		list.add("maria");
		return list;

	}
}

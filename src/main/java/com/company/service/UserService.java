package com.company.service;

import com.company.model.User;
import com.company.payload.GenericResponse;

public interface UserService {

	GenericResponse<?> findAll();

	GenericResponse<?> findById(Long id);

	GenericResponse<?> save(User user);
}

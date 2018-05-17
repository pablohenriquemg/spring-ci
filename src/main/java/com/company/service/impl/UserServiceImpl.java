package com.company.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.company.exception.BadRequestException;
import com.company.exception.NotFoundException;
import com.company.model.User;
import com.company.payload.GenericResponse;
import com.company.payload.MessageResponse;
import com.company.repository.UserRepository;
import com.company.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	@Override
	public GenericResponse<?> findAll() {
		try {
			return new GenericResponse<>(userRepository.findAll(), null);
		} catch (Exception e) {
			MessageResponse error = new MessageResponse("not.located", "Users not find, please try again later.");
			GenericResponse<?> genericResponse = new GenericResponse<>().withError(error);
			throw new BadRequestException(genericResponse);
		}
	}

	@Override
	public GenericResponse<?> findById(Long id) {
		User usr = userRepository.findById(id);
		if (usr == null) {
			MessageResponse error = new MessageResponse("not.found", "User not found");
			GenericResponse<?> genericResponse = new GenericResponse<>().withError(error);
			throw new NotFoundException(genericResponse);
		}
		return new GenericResponse<>(usr, null);
	}

	@Override
	public GenericResponse<?> save(User user) {
		try {
			user.setPassword(passwordEncoder.encode(user.getPassword()));
			return new GenericResponse<>(userRepository.save(user), null);
		} catch (Exception e) {
			MessageResponse error = new MessageResponse("not.saved",
					"User not saved, please check the fields and then try again.");
			GenericResponse<?> genericResponse = new GenericResponse<>().withError(error);
			throw new BadRequestException(genericResponse);
		}
	}

}

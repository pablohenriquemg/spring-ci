package com.company.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

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
			MessageResponse error = new MessageResponse("not.located", "Users not find, try again later.");
			return new GenericResponse<>(null, error);
		}
	}

	@Override
	public GenericResponse<?> findById(Long id) {
		User usr = userRepository.findById(id);
		if (usr == null) {
			MessageResponse error = new MessageResponse("not.found", "User not found");
			return new GenericResponse<>(null, error);
		}
		return new GenericResponse<>(usr, null);
	}

	@Override
	public GenericResponse<?> save(User user) {
		try {
			user.setPassword(passwordEncoder.encode(user.getPassword()));
			return new GenericResponse<>(userRepository.save(user), null);
		} catch (Exception e) {
			MessageResponse error = new MessageResponse("not.saved", "User not saved, try again later.");
			return new GenericResponse<>(null, error);
		}
	}

}

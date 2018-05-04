package com.company.repository;

import java.util.List;

import org.springframework.data.repository.Repository;

import com.company.model.User;

public interface UserRepository extends Repository<User, Long> {

	User save(User entity);

	List<User> findAll();

	User findById(Long id);
}

package com.javaexpress.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.javaexpress.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {

	// input username output is user
	Optional<User> findByCredentialUsername(String username);
}

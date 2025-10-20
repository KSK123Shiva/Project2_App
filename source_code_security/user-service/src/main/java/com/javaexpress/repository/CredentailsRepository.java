package com.javaexpress.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.javaexpress.model.Credential;

public interface CredentailsRepository extends JpaRepository<Credential, Integer> {

	Optional<Credential> findByUsername(final String username);
}

package com.javaexpress.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.javaexpress.model.Address;
import com.javaexpress.model.Credential;

public interface CredentailsRepository extends JpaRepository<Credential, Integer> {

}

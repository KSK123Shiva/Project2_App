package com.javaexpress.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.javaexpress.entities.Cart;

public interface CartRepository extends JpaRepository<Cart, Integer>{

}

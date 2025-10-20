package com.javaexpress.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.javaexpress.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Integer>{

}

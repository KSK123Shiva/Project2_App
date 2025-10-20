package com.javaexpress.repository;

import com.javaexpress.domains.OrderItem;
import com.javaexpress.domains.OrderItemId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem, OrderItemId>{
}

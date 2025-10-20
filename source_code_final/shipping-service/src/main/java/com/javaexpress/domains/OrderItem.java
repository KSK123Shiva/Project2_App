package com.javaexpress.domains;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="order_items")
@IdClass(OrderItemId.class)
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class OrderItem {

	@Id
	@Column(name="product_id",nullable = false,updatable = false)
	private Integer productId;
	
	@Id
	@Column(name="order_id",nullable = false,updatable = false)
	private Integer orderId;
	
	private Integer orderQuantity;
}

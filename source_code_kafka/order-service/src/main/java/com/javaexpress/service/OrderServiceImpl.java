package com.javaexpress.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaexpress.dto.AuditLog;
import com.javaexpress.dto.OrderDto;
import com.javaexpress.feignclients.AuditFeignClient;
import com.javaexpress.helpers.OrderMappingHelper;
import com.javaexpress.repository.OrderRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class OrderServiceImpl {

	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private AuditFeignClient auditFeignClient;
	
	public OrderDto save(OrderDto orderDto) {
		orderDto.setOrderDate(LocalDateTime.now());
		log.info("OrderServiceIMPL :: save");
		var result = OrderMappingHelper.map(orderRepository.save(OrderMappingHelper.map(orderDto)));
		AuditLog log = new AuditLog("order-service", "order-created", 
				String.valueOf(orderDto.getUserId()));
		auditFeignClient.logEvent(log);
		// publish to audit-topic as event
		return result;
	}
	
	
	public OrderDto findById(Integer orderId) {
		log.info("*** OrderDto, service; fetch order by id *");
		return this.orderRepository.findById(orderId)
				.map(OrderMappingHelper::map)
				.orElseThrow(() -> new RuntimeException(String
						.format("Order with id: %d not found", orderId)));
	}
}

package com.javaexpress.controller;

import com.javaexpress.dtos.OrderItemDto;
import com.javaexpress.service.OrderItemService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping("/api/order-items")
public class OrderItemController {

    @Autowired
    private OrderItemService orderItemService;

    @PostMapping
    public ResponseEntity<OrderItemDto> save(@RequestBody OrderItemDto orderItemDto){
        log.info("Saving order item: {}", orderItemDto);
        return ResponseEntity.ok(orderItemService.save(orderItemDto));
    }
}

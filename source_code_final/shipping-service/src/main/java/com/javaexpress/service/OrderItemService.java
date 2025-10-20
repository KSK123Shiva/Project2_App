package com.javaexpress.service;

import com.javaexpress.dtos.OrderItemDto;
import com.javaexpress.helpers.OrderItemMappingHelper;
import com.javaexpress.repository.OrderItemRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class OrderItemService {

    @Autowired
    private OrderItemRepository orderItemRepository;

    public OrderItemDto save(OrderItemDto orderItemDto){
        log.info("Saving order item: {}", orderItemDto);
        return  OrderItemMappingHelper.map(
                orderItemRepository.save(OrderItemMappingHelper.map(orderItemDto)));
    }
    
}

package com.javaexpress.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaexpress.dtos.PaymentDto;
import com.javaexpress.feignclients.OrderFeignClient;
import com.javaexpress.helpers.PaymentMappingHelper;
import com.javaexpress.repository.PaymentRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;
    
    @Autowired
    private OrderFeignClient orderFeignClient;

    public PaymentDto save(PaymentDto paymentDto){
        log.info("PaymentService :: Saving payment: {}", paymentDto);
        var result = paymentRepository.save(PaymentMappingHelper.map(paymentDto));
        return PaymentMappingHelper.map(result);
    }
    
	public PaymentDto findById(Integer paymentId) {
		log.info("PaymentService :: findByid {}",paymentId);
		return paymentRepository.findById(paymentId)
				.map(PaymentMappingHelper::map)
				.map(p -> {
					p.setOrderDto(
							orderFeignClient.findById(p.getOrderDto().getOrderId()).getBody());
					return p;
				})
				.orElseThrow(() -> new RuntimeException("Payment Id Not Found Exception"));
	}
}

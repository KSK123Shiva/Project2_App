package com.javaexpress.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javaexpress.dtos.PaymentDto;
import com.javaexpress.services.PaymentService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api/payments")
@Slf4j
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @PostMapping
    public ResponseEntity<PaymentDto> savePayment(@RequestBody PaymentDto paymentDto){
        var output  = paymentService.save(paymentDto);
        return ResponseEntity.ok().body(output);
    }
    
    @GetMapping("/{paymentId}")
    public ResponseEntity<PaymentDto> findById(@PathVariable Integer paymentId) {
    	log.info("PaymentController :: findById");
    	return ResponseEntity.ok(paymentService.findById(paymentId));
    }
}

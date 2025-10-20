package com.javaexpress.helpers;

import com.javaexpress.dtos.OrderDto;
import com.javaexpress.dtos.PaymentDto;
import com.javaexpress.entities.Payment;

public interface PaymentMappingHelper {

    static PaymentDto map(Payment payment){
        return PaymentDto.builder()
                .paymentId(payment.getPaymentId())
                .isPayed(payment.getIsPayed())
                .paymentStatus(payment.getPaymentStatus())
                .orderDto(
                        OrderDto.builder()
                                .orderId(payment.getOrderId())
                                .build()
                )
                .build();
    }

    static Payment map(PaymentDto paymentDto){
        return Payment.builder()
                .paymentId(paymentDto.getPaymentId())
                .isPayed(paymentDto.getIsPayed())
                .paymentStatus(paymentDto.getPaymentStatus())
                .orderId(paymentDto.getOrderDto().getOrderId())
                .build();
    }

}

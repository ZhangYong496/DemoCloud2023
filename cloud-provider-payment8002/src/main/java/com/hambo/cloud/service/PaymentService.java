package com.hambo.cloud.service;

import com.hambo.cloud.entities.Payment;
import org.apache.ibatis.annotations.Param;


public interface PaymentService {

    int create(Payment payment);

    Payment getPaymentById(@Param("id") Long id);

}

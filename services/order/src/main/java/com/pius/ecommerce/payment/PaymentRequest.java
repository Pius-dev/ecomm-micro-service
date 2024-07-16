package com.pius.ecommerce.payment;

import com.pius.ecommerce.customer.CustomerResponse;
import com.pius.ecommerce.entity.PaymentMethod;

import java.math.BigDecimal;

public record PaymentRequest(

        BigDecimal amount,
        PaymentMethod paymentMethod,
        Integer orderId,
        String orderReference,
        CustomerResponse customer
) {
}

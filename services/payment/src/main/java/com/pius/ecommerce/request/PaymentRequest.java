package com.pius.ecommerce.request;

import com.pius.ecommerce.customer.Customer;
import com.pius.ecommerce.entity.PaymentMethod;

import java.math.BigDecimal;

public record PaymentRequest(
        Integer id,
        BigDecimal amount,
        PaymentMethod paymentMethod,

        Integer orderId,
        String orderReference,
        Customer customer
) {
}

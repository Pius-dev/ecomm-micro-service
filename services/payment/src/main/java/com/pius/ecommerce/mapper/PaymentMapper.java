/**
 * Created By Eng. Pius Obonyo
 * Date: 7/12/24
 * Time: 9:35 PM
 */

package com.pius.ecommerce.mapper;

import com.pius.ecommerce.entity.Payment;
import com.pius.ecommerce.request.PaymentRequest;
import org.springframework.stereotype.Service;

@Service
public class PaymentMapper {
    public Payment toPayment(PaymentRequest request) {
        return Payment.builder()
                .id(request.id())
                .orderId(request.orderId())
                .amount(request.amount())
                .paymentMethod(request.paymentMethod())
                .build();
    }
}


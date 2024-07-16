/**
 * Created By Eng. Pius Obonyo
 * Date: 7/12/24
 * Time: 9:10 PM
 */

package com.pius.ecommerce.service;

import com.pius.ecommerce.mapper.PaymentMapper;
import com.pius.ecommerce.notification.PaymentNotificationProducer;
import com.pius.ecommerce.notification.PaymentNotificationRequest;
import com.pius.ecommerce.repository.PaymentRepository;
import com.pius.ecommerce.request.PaymentRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PaymentService {

    private final PaymentRepository paymentRepository;
    private final PaymentMapper mapper;
    private final PaymentNotificationProducer notificationProducer;

    public Integer makePayment(PaymentRequest request) {

        var payment = paymentRepository.save(mapper.toPayment(request));

        notificationProducer.sendNotification(
                new PaymentNotificationRequest(
                        request.orderReference(),
                        request.amount(),
                        request.paymentMethod(),
                        request.customer().firstName(),
                        request.customer().lastName(),
                        request.customer().email()
                )
        );

        return payment.getId();
    }
}


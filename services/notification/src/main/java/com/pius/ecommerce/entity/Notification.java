/**
 * Created By Eng. Pius Obonyo
 * Date: 7/14/24
 * Time: 1:42 PM
 */

package com.pius.ecommerce.entity;

import com.pius.ecommerce.kafka.order.OrderConfirmation;
import com.pius.ecommerce.kafka.payment.PaymentConfirmation;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document
public class Notification {
    @Id
    private String id;
    private NotificationType notificationType;
    private LocalDateTime notificationDate;
    private OrderConfirmation orderConfirmation;
    private PaymentConfirmation paymentConfirmation;
}


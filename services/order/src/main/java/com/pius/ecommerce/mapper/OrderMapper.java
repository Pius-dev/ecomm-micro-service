/**
 * Created By Eng. Pius Obonyo
 * Date: 7/10/24
 * Time: 4:53 PM
 */

package com.pius.ecommerce.mapper;

import com.pius.ecommerce.entity.Order;
import com.pius.ecommerce.requests.OrderRequest;
import com.pius.ecommerce.response.OrderResponse;
import org.springframework.stereotype.Service;

@Service
public class OrderMapper {
    public Order toOrder(OrderRequest request) {
        return  Order.builder()
                .id(request.id())
                .customerId(request.customerId())
                .reference(request.reference())
                .totalAmount(request.amount())
                .paymentMethod(request.paymentMethod())
                .build();
    }

    public OrderResponse fromOrder(Order order){
        return new OrderResponse(
                order.getId(),
                order.getReference(),
                order.getTotalAmount(),
                order.getPaymentMethod(),
                order.getCustomerId()
        );
    }
}


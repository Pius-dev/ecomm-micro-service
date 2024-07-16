/**
 * Created By Eng. Pius Obonyo
 * Date: 7/10/24
 * Time: 8:38 PM
 */

package com.pius.ecommerce.mapper;

import com.pius.ecommerce.entity.Order;
import com.pius.ecommerce.orderline.OrderLine;
import com.pius.ecommerce.orderline.OrderLineRequest;
import com.pius.ecommerce.orderline.OrderLineResponse;
import org.springframework.stereotype.Service;

@Service
public class OrderLineMapper {
    public OrderLine toOrderLine(OrderLineRequest request) {

        return OrderLine.builder()
                .id(request.id())
                .quantity(request.quantity())
                .order(
                        Order.builder()
                                .id(request.orderId())
                                .build()
                )
                .productId(request.productId())
                .build();
    }

    public OrderLineResponse toOrderLineResponse(OrderLine orderLine) {
        return new OrderLineResponse(
                orderLine.getId(),
                orderLine.getQuantity()
        );
    }
}


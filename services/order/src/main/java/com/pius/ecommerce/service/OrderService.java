package com.pius.ecommerce.service;

import com.pius.ecommerce.requests.OrderRequest;
import com.pius.ecommerce.response.OrderResponse;

import java.util.List;

public interface OrderService {
    Integer createOrder(OrderRequest request);

    List<OrderResponse> findAllOrders();

    OrderResponse findOrderById(Integer orderId);
}

/**
 * Created By Eng. Pius Obonyo
 * Date: 7/4/24
 * Time: 5:09 PM
 */

package com.pius.ecommerce.service;

import com.pius.ecommerce.OrderRepository;
import com.pius.ecommerce.customer.CustomerClient;
import com.pius.ecommerce.exception.BusinessException;
import com.pius.ecommerce.kafka.OrderConfirmation;
import com.pius.ecommerce.kafka.OrderProducer;
import com.pius.ecommerce.mapper.OrderMapper;
import com.pius.ecommerce.orderline.OrderLineRequest;
import com.pius.ecommerce.orderline.OrderLineService;
import com.pius.ecommerce.payment.PaymentClient;
import com.pius.ecommerce.payment.PaymentRequest;
import com.pius.ecommerce.product.ProductClient;
import com.pius.ecommerce.requests.OrderRequest;
import com.pius.ecommerce.requests.ProductPurchaseRequest;
import com.pius.ecommerce.response.OrderResponse;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final CustomerClient customerClient;
    private final ProductClient productClient;
    private final OrderRepository orderRepository;
    private final OrderMapper mapper;
    private final OrderLineService orderLineService;
    private final OrderProducer orderProducer;
    private final PaymentClient paymentClient;

    @Override
    public Integer createOrder(OrderRequest request) {
        // check customer exist (We use the FeignClient to fetch the customer from customer-service ms)
        var customer = customerClient.findCustomerById(request.customerId())
                .orElseThrow(() -> new BusinessException("Cannot create order:: No customer found with the provided id"));

        // purchase the products from product-service ms using (RestTemplate)
        var purchasedProducts = productClient.purchaseProducts(request.products());

        //persist the order
        var order = orderRepository.save(mapper.toOrder(request));

        //persist the order line
        for (ProductPurchaseRequest purchaseRequest : request.products()) {
            orderLineService.saveOrderLine(
                    new OrderLineRequest(
                            null,
                            order.getId(),
                            purchaseRequest.productId(),
                            purchaseRequest.quantity()
                    )
            );
        }
        // Start the payment process
        var paymentRequest = new PaymentRequest(
                request.amount(),
                request.paymentMethod(),
                order.getId(),
                order.getReference(),
                customer
        );

        paymentClient.requestOrderPayment(paymentRequest);

        // send the order confirmation notification to notification-ms
        orderProducer.sendOrderConfirmation(
                new OrderConfirmation(
                        request.reference(),
                        request.amount(),
                        request.paymentMethod(),
                        customer,
                        purchasedProducts
                )
        );

        return order.getId();
    }

    @Override
    public List<OrderResponse> findAllOrders() {
        return orderRepository.findAll()
                .stream()
                .map(mapper::fromOrder)
                .collect(Collectors.toList());
    }

    @Override
    public OrderResponse findOrderById(Integer orderId) {
        return orderRepository.findById(orderId)
                .map(mapper::fromOrder)
                .orElseThrow(() -> new EntityNotFoundException(String
                        .format("No order found with the provided id: %d", orderId)));
    }
}


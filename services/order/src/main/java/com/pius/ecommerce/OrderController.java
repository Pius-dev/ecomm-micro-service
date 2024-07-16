/**
 * Created By Eng. Pius Obonyo
 * Date: 7/4/24
 * Time: 5:08 PM
 */

package com.pius.ecommerce;

import com.pius.ecommerce.requests.OrderRequest;
import com.pius.ecommerce.response.OrderResponse;
import com.pius.ecommerce.service.OrderService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/orders")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @PostMapping("/makeOrder")
    public ResponseEntity<Integer> createOrder(@RequestBody @Valid OrderRequest request){
        return ResponseEntity.ok(orderService.createOrder(request));
    }


    @GetMapping("/all")
    public ResponseEntity<List<OrderResponse>> findAll(){
        return ResponseEntity.ok(orderService.findAllOrders());
    }

    @GetMapping("/orderById/{order-id}")
    public ResponseEntity<OrderResponse> findById(@PathVariable("order-id") Integer orderId){
        return ResponseEntity.ok(orderService.findOrderById(orderId));
    }
}


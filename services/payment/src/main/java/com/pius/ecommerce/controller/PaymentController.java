/**
 * Created By Eng. Pius Obonyo
 * Date: 7/12/24
 * Time: 9:09 PM
 */

package com.pius.ecommerce.controller;

import com.pius.ecommerce.request.PaymentRequest;
import com.pius.ecommerce.service.PaymentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/payment")
public class PaymentController {

    private final PaymentService paymentService;

    @PostMapping("/makePayment")
    public ResponseEntity<Integer> makePayment(@RequestBody @Valid PaymentRequest request){
        return ResponseEntity.ok(paymentService.makePayment(request));
    }
}


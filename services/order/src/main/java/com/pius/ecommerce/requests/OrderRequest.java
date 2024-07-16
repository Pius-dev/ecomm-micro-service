/**
 * Created By Eng. Pius Obonyo
 * Date: 7/4/24
 * Time: 5:19 PM
 */

package com.pius.ecommerce.requests;

import com.pius.ecommerce.entity.PaymentMethod;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.util.List;

public record OrderRequest(
        Integer id,
        String reference,
        @NotNull(message = "Order should be positive")
        BigDecimal amount,
        @NotNull(message = "Payment method should be supplied")
        PaymentMethod paymentMethod,
        @NotNull(message = "Customer should be present")
        @NotEmpty(message = "Customer should be present")
        @NotBlank(message = "Customer should be present")
        String customerId,
        @NotEmpty(message = "You should have at least one product")
        List<ProductPurchaseRequest> products
) {
}


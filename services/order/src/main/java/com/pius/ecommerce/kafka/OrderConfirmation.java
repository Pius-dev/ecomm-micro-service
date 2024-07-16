/**
 * Created By Eng. Pius Obonyo
 * Date: 7/10/24
 * Time: 10:40 PM
 */

package com.pius.ecommerce.kafka;

import com.pius.ecommerce.customer.CustomerResponse;
import com.pius.ecommerce.entity.PaymentMethod;
import com.pius.ecommerce.product.ProductPurchaseResponse;

import java.math.BigDecimal;
import java.util.List;

public record OrderConfirmation(
        String orderReference,
        BigDecimal totalAmount,
        PaymentMethod paymentMethod,
        CustomerResponse customer,
        List<ProductPurchaseResponse> products
) {
}


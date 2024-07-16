package com.pius.ecommerce.product;

import java.util.List;

public interface ProductService {
    Integer createProduct(ProductRequest request);

    List<ProductPurchaseResponse> purchaseProduct(List<ProductPurchaseRequest> request);

    ProductResponse findProductById(Integer productId);

    List<ProductResponse> findAll();
}

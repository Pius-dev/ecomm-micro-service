/**
 * Created By Eng. Pius Obonyo
 * Date: 7/4/24
 * Time: 10:59 PM
 */

package com.pius.ecommerce.product;

import com.pius.ecommerce.exception.BusinessException;
import com.pius.ecommerce.requests.ProductPurchaseRequest;
import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductClient {

    @Value("${application.config.product-url}")
    private String productUrl;

    private final RestTemplate restTemplate;

    public List<ProductPurchaseResponse> purchaseProducts(List<ProductPurchaseRequest> requestBody){
        HttpHeaders headers = new HttpHeaders();
        headers.set(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);

        HttpEntity<List<ProductPurchaseRequest>> requestEntity = new HttpEntity<>(requestBody, headers);
        ParameterizedTypeReference<List<ProductPurchaseResponse>> responseType =
                new ParameterizedTypeReference<>() {};

        ResponseEntity<List<ProductPurchaseResponse>> responseEntity = restTemplate.exchange(
                productUrl + "/purchase",
                HttpMethod.POST,
                requestEntity,
                responseType
        );

        if (responseEntity.getStatusCode().isError()){
            throw new BusinessException("An error occurred while processing the product purchase: " + responseEntity.getStatusCode());
        }
        return  responseEntity.getBody();


    }
}


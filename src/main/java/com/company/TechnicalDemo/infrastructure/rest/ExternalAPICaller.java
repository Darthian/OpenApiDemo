package com.company.TechnicalDemo.infrastructure.rest;

import com.company.TechnicalDemo.domain.repository.ProductRepository;
import com.company.TechnicalDemo.model.ProductDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.CompletableFuture;

@Service
public class ExternalAPICaller implements ProductRepository {

    private final RestTemplate restTemplate;

    @Autowired
    public ExternalAPICaller(RestTemplate restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder;
    }

    @Async
    @Override
    public Integer[] getProductsIds(String productId) {
        return restTemplate.getForObject("/product/" + productId + "/similarids", Integer[].class);
    }

    @Async
    @Override
    public CompletableFuture<ProductDetail> getProductDetail(Integer productId) {
        return CompletableFuture.completedFuture(restTemplate.getForObject(
                "/product/" + productId, ProductDetail.class));
    }
}

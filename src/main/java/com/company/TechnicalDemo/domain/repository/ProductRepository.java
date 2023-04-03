package com.company.TechnicalDemo.domain.repository;

import com.company.TechnicalDemo.model.ProductDetail;

import java.util.concurrent.CompletableFuture;

public interface ProductRepository {

    Integer[] getProductsIds(String productId);
    CompletableFuture<ProductDetail> getProductDetail(Integer productId);
}

package com.company.TechnicalDemo.domain.service;

import com.company.TechnicalDemo.domain.repository.ProductRepository;
import com.company.TechnicalDemo.model.ProductDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.CompletableFuture;

@Service
public class ProductService {

    private ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Set<ProductDetail> getSimilarProduct(String productId) {
        Set<ProductDetail> set = new HashSet<>();
        Integer[] result;
        try {
            result = productRepository.getProductsIds(productId);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        Arrays.stream(result).map(obtainedId -> {
            try {
                return productRepository.getProductDetail(obtainedId).thenAccept(
                        obtainedProduct -> set.add(obtainedProduct));
            } catch (NotFoundException e) {
                throw new NotFoundException(e.getMessage());
            }
        }).map(CompletableFuture::join).toList();
        return set;
    }
}

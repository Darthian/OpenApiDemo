package com.company.TechnicalDemo.api;

import com.company.TechnicalDemo.domain.service.ProductService;
import com.company.TechnicalDemo.model.ProductDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
public class ProductApiControllerImpl implements ProductApi {

    private final ProductService productService;

    @Autowired
    public ProductApiControllerImpl(ProductService productService) {
        this.productService = productService;
    }

    @Override
    public ResponseEntity<Set<ProductDetail>> _getProductSimilar(String productId) {

        return new ResponseEntity<>(productService.getSimilarProduct(productId), HttpStatus.OK);
    }
}

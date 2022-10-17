package com.example.springapp.domain.service;

import com.example.springapp.common.dto.ProductDto;
import com.example.springapp.domain.entity.Product;

import java.math.BigDecimal;
import java.util.List;

public interface ProductService {
    List<Product> findAllProducts();
    Product findProductById(Long id);
    Product createProduct(ProductDto productDto);
    Product updateProduct(ProductDto productDto);
    Product updateProductPriceById(Long id, BigDecimal price);
    void disableProductById(Long id);
}

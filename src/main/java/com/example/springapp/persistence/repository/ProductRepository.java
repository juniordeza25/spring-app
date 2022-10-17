package com.example.springapp.persistence.repository;

import com.example.springapp.domain.entity.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, Long> {
    Product findProductByIdAndDeleted(Long id, Boolean deleted);
}

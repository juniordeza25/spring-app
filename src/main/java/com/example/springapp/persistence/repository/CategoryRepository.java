package com.example.springapp.persistence.repository;

import com.example.springapp.domain.entity.Category;
import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends CrudRepository<Category, Short> {
    Category findCategoryById(Short id);
    Boolean existsByName(String name);
}

package com.example.springapp.domain.service;

import com.example.springapp.common.dto.CategoryDto;
import com.example.springapp.domain.entity.Category;

import java.util.List;

public interface CategoryService {
    List<Category> findAllCategories();
    Category findCategoryById(Short id);
    Category createCategory(CategoryDto categoryDto);
    Category updateCategory(CategoryDto categoryDto);
    void deleteCategoryById(Short id);
}

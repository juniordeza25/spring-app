package com.example.springapp.web.controller;

import com.example.springapp.common.dto.CategoryDto;
import com.example.springapp.domain.entity.Category;
import com.example.springapp.domain.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/v1/categories")
@RequiredArgsConstructor
public class CategoryController {
    private final CategoryService categoryService;

    @GetMapping(produces = "application/json")
    public ResponseEntity<List<Category>> getAllCategories() {
        return new ResponseEntity<>(categoryService.findAllCategories(), HttpStatus.OK);
    }

    @GetMapping(value = "/{id}", produces = "application/json")
    public ResponseEntity<Category> getCategoryById(@PathVariable("id") Short id){
        return new ResponseEntity<>(categoryService.findCategoryById(id), HttpStatus.OK);
    }

    @PostMapping(consumes = "application/json", produces = "application/json")
    public ResponseEntity<Category> createCategory(@Valid @RequestBody CategoryDto categoryDto){
        return new ResponseEntity<>(categoryService.createCategory(categoryDto), HttpStatus.CREATED);
    }

    @PutMapping(consumes = "application/json", produces = "application/json")
    public ResponseEntity<Category> updateCategory(@Valid @RequestBody CategoryDto categoryDto){
        return new ResponseEntity<>(categoryService.updateCategory(categoryDto), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteCategoryById(@PathVariable("id") Short id){
        categoryService.deleteCategoryById(id);
        return new ResponseEntity(HttpStatus.OK);
    }
}

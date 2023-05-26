package com.carsharing.controllers;

import com.carsharing.models.Category;
import com.carsharing.services.CategoryService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/categories")
public class CategoryController {
    private final CategoryService categoryService;

    public CategoryController(
        CategoryService categoryService
    ) {
        this.categoryService = categoryService;
    }

    @GetMapping("/")
    public List<Category> findAll() {
        return categoryService.findAll();
    }

    @GetMapping("/{id}")
    public Category findById(@PathVariable long id) {
        return categoryService.findById(id);
    }

    @PostMapping("/")
    public Category save(@RequestBody Category category) {
        return categoryService.save(category);
    }

    @PutMapping("/{id}")
    public Category update(
        @PathVariable long id,
        @RequestBody Category category
    ) {
        return categoryService.update(id, category);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable long id) {
        categoryService.delete(new Category(id));
    }

    @GetMapping("/{name}")
    public Category findByName(@PathVariable String name) {
        return categoryService.findByName(name);
    }
}

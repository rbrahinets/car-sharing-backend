package com.carsharing.services;

import com.carsharing.models.Category;
import com.carsharing.repositories.CategoryRepository;
import com.carsharing.validators.CategoryValidator;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {
    private final CategoryRepository categoryRepository;
    private final CategoryValidator categoryValidator;

    public CategoryService(
        CategoryRepository categoryRepository,
        CategoryValidator categoryValidator
    ) {
        this.categoryRepository = categoryRepository;
        this.categoryValidator = categoryValidator;
    }

    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    public Category findById(long id) {
        categoryValidator.validate(id, categoryRepository.findAll());
        return categoryRepository.findById(id).orElseThrow();
    }

    public Category save(Category category) {
        categoryValidator.validate(category, categoryRepository.findAll());
        categoryRepository.save(category);
        return category;
    }

    public Category update(long id, Category category) {
        categoryValidator.validate(id, categoryRepository.findAll());
        categoryValidator.validate(category, categoryRepository.findAll());
        categoryRepository.update(id, category);
        return category;
    }

    public void delete(Category category) {
        categoryValidator.validate(category, categoryRepository.findAll());
        categoryRepository.delete(category);
    }

    public Category findByName(String name) {
        categoryValidator.validate(name, categoryRepository.findAll());
        return categoryRepository.findByName(name).orElseThrow();
    }
}

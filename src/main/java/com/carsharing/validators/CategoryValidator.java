package com.carsharing.validators;

import com.carsharing.exceptions.NotFoundException;
import com.carsharing.exceptions.ValidationException;
import com.carsharing.models.Category;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CategoryValidator {
    public void validate(Category category, List<Category> categories) {
        if (isNameInvalid(category.getName())) {
            throw new ValidationException("Name is invalid");
        } else if (isNameAlreadyExists(category.getName(), categories)) {
            throw new ValidationException("Name already exist");
        }
    }

    public void validate(long id, List<Category> categories) {
        List<Long> ids = new ArrayList<>();

        for (Category category : categories) {
            ids.add(category.getId());
        }

        if (!ids.contains(id)) {
            throw new NotFoundException("Category not found");
        }
    }

    public void validate(String name, List<Category> categories) {
        if (!getNames(categories).contains(name)) {
            throw new NotFoundException("Category not found");
        }
    }

    private static boolean isNameInvalid(String name) {
        return name == null
            || name.isBlank();
    }

    private boolean isNameAlreadyExists(String name, List<Category> categories) {
        return getNames(categories).contains(name);
    }

    private static List<String> getNames(List<Category> categories) {
        List<String> names = new ArrayList<>();

        for (Category category : categories) {
            names.add(category.getName());
        }
        return names;
    }
}
